import java.io.*;
import java.util.*;
public class ShortestPathRevisited{
    static class Edge{
        int to;
        long w;
        Edge(int t, long w){
            this.to = t;
            this.w = w;
        }
    }
    static class State implements Comparable<State> {
        int node;
        long dist;
        State(int n, long d) {
            node = n;
            dist = d;
        }
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }
    static final long INF = (long) 1e18;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int S = Integer.parseInt(first[2]);
        int D = Integer.parseInt(first[3]);
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            long w = Long.parseLong(line[2]);
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        long[] dist1 = new long[N + 1];
        long[] dist2 = new long[N + 1];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist1[S] = 0;
        pq.add(new State(S, 0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;
            if (d > dist2[u]){
                continue;
            }
            for(Edge e : adj[u]){
                long nd = d + e.w;
                if(nd < dist1[e.to]){
                    dist2[e.to] = dist1[e.to];
                    dist1[e.to] = nd;
                    pq.add(new State(e.to, nd));
                } 
                else if(nd > dist1[e.to] && nd < dist2[e.to]){
                    dist2[e.to] = nd;
                    pq.add(new State(e.to, nd));
                }
            }
        }
        if (dist2[D] == INF){
            out.println(-1);
        }
        else{
            out.println(dist2[D]);
        }
        out.flush();
    }
}
