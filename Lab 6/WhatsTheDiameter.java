import java.io.*;
import java.util.*;
public class WhatsTheDiameter{
    static ArrayList<Integer>[] adj;
    static int N;
    static class Pair{
        int node, distance;
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static Pair bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        visited[start] = true;
        Pair farthest = new Pair(start, 0);
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            if(cur.distance > farthest.distance){
                farthest = cur;
            }
            for(int v : adj[cur.node]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(new Pair(v, cur.distance + 1));
                }
            }
        }
        return farthest;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++){
            String[] inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        Pair p1 = bfs(1);
        Pair p2 = bfs(p1.node);
        pw.println(p2.distance);
        pw.println(p1.node + " " + p2.node);
        pw.flush();
    }
}