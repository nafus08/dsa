import java.io.*;
import java.util.*;
public class BeautifulPath{
    static class Edge{
        int to;
        Edge(int to){
            this.to = to;
        }
    }
    static class Node implements Comparable<Node>{
        int v;
        long dist;
        Node(int v, long dist){
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Node o){
            return Long.compare(this.dist, o.dist);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[] weight = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v));
        }
        if(S == D){
            System.out.println(weight[S]);
            return;
        }
        long INF = Long.MAX_VALUE;
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[S] = weight[S];
        pq.add(new Node(S, dist[S]));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int u = cur.v;
            if (cur.dist != dist[u]){
                continue;
            }
            for(Edge e : adj[u]){
                int v = e.to;
                long newDist = dist[u] + weight[v];
                if (newDist < dist[v]){
                    dist[v] = newDist;
                    pq.add(new Node(v, newDist));
                }
            }
        }
        if(dist[D] == INF){
            System.out.println(-1);
        } 
        else{
            System.out.println(dist[D]);
        }
    }
}