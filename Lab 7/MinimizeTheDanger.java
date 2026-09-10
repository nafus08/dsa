import java.io.*;
import java.util.*;
public class MinimizeTheDanger{
    static class Edge{
        int to;
        int w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
    static class State implements Comparable<State>{
        int node;
        int danger;
        State(int node, int danger){
            this.node = node;
            this.danger = danger;
        }
        public int compareTo(State o){
            return this.danger - o.danger;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int u = cur.node;
            if (cur.danger > dist[u]){
                continue;
            }
            for(Edge e : adj[u]){
                int v = e.to;
                int newDanger = Math.max(dist[u], e.w);
                if(newDanger < dist[v]){
                    dist[v] = newDanger;
                    pq.add(new State(v, newDanger));
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if (dist[i] == INF){
                out.print("-1 ");
            }
            else{
                out.print(dist[i] + " ");
            }
        }
        out.println();
        out.flush();
    }
}