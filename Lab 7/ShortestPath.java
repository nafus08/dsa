import java.io.*;
import java.util.*;
public class ShortestPath{
    static class Edge{
        int to;
        long w;
        Edge(int to, long w){
            this.to = to;
            this.w = w;
        }
    }
    static class Node implements Comparable<Node>{
        int v;
        long dist;
        Node(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int S = Integer.parseInt(first[2]);
        int D = Integer.parseInt(first[3]);

        String[] uStr = br.readLine().split(" ");
        String[] vStr = br.readLine().split(" ");
        String[] wStr = br.readLine().split(" ");
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int u = Integer.parseInt(uStr[i]);
            int v = Integer.parseInt(vStr[i]);
            long w = Long.parseLong(wStr[i]);
            adj[u].add(new Edge(v, w));
        }
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[S] = 0;
        pq.add(new Node(S, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int u = cur.v;
            if(cur.dist != dist[u]){
                continue;
            }
            for(Edge e : adj[u]){
                int v = e.to;
                long nd = dist[u] + e.w;
                if(nd < dist[v]){
                    dist[v] = nd;
                    parent[v] = u;
                    pq.add(new Node(v, nd));
                }
            }
        }
        if(dist[D] == INF){
            out.println(-1);
        } 
        else{
            out.println(dist[D]);
            ArrayList<Integer> path = new ArrayList<>();
            for(int cur = D; cur != -1; cur = parent[cur]){
                path.add(cur);
            }
            Collections.reverse(path);
            for(int x : path){
                out.print(x + " ");
            }
            out.println();
        }
        out.flush();
    }
}
