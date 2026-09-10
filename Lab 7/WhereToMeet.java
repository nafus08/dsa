import java.io.*;
import java.util.*;
public class WhereToMeet{
    static class Edge{
        int to;
        long w;
        Edge(int to, long w){
            this.to = to;
            this.w = w;
        }
    }
    static class State implements Comparable<State> {
        int node;
        long dist;
        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }
    static final long INF = Long.MAX_VALUE / 4;
    static long[] dijkstra(int start, ArrayList<Edge>[] adj, int N) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new State(start, 0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;
            if (d != dist[u]){
                continue;
            }
            for(Edge e : adj[u]){
                int v = e.to;
                long nd = d + e.w;
                if(nd < dist[v]){
                    dist[v] = nd;
                    pq.add(new State(v, nd));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj[u].add(new Edge(v, w));
        }
        long[] distS = dijkstra(S, adj, N);
        long[] distT = dijkstra(T, adj, N);
        long bestTime = INF;
        int bestNode = -1;
        for(int i = 1; i <= N; i++){
            if (distS[i] == INF || distT[i] == INF){
                continue;
            }
            long meetTime = Math.max(distS[i], distT[i]);
            if (meetTime < bestTime || 
               (meetTime == bestTime && i < bestNode)) {
                bestTime = meetTime;
                bestNode = i;
            }
        }
        if(bestNode == -1){
            System.out.println("-1");
        } 
        else{
            System.out.println(bestTime + " " + bestNode);
        }
    }
}