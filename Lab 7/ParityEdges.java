import java.io.*;
import java.util.*;
public class ParityEdges{
    static class Edge{
        int to;
        int w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
    static class State{
        int node, parity;
        long dist;
        State(int node, int parity, long dist){
            this.node = node;
            this.parity = parity;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        String[] c = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            u[i] = Integer.parseInt(a[i]);
            v[i] = Integer.parseInt(b[i]);
            w[i] = Integer.parseInt(c[i]);
        }
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            adj[u[i]].add(new Edge(v[i], w[i]));
        }
        long INF = (long) 1e18;
        long[][] dist = new long[N + 1][2];
        for(int i = 1; i <= N; i++){
            dist[i][0] = dist[i][1] = INF;
        }
        PriorityQueue<State> pq = new PriorityQueue<>(
            (x, y) -> Long.compare(x.dist, y.dist)
        );
        dist[1][0] = dist[1][1] = 0;
        pq.add(new State(1, 0, 0));
        pq.add(new State(1, 1, 0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int uNode = cur.node;
            int lastParity = cur.parity;
            if (cur.dist != dist[uNode][lastParity]){
                continue;
            }
            for (Edge e : adj[uNode]) {
                int edgeParity = e.w % 2;
                if (edgeParity == lastParity) continue;
                long nd = cur.dist + e.w;
                if(nd < dist[e.to][edgeParity]){
                    dist[e.to][edgeParity] = nd;
                    pq.add(new State(e.to, edgeParity, nd));
                }
            }
        }
        long ans = Math.min(dist[N][0], dist[N][1]);
        out.println(ans == INF ? -1 : ans);
        out.flush();
    }
}