import java.io.*;
import java.util.*;
public class LightningMcQueen{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int S = Integer.parseInt(inputs[2]);
        int D = Integer.parseInt(inputs[3]);
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        String[] U = new String[0];
        String[] V = new String[0];
        if (M > 0){
            U = br.readLine().split(" ");
            V = br.readLine().split(" ");
        }
        for(int i = 0; i < M; i++){
            int u = Integer.parseInt(U[i]);
            int v = Integer.parseInt(V[i]);
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 1; i <= N; i++){
            Collections.sort(adj[i]);
        }
        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        dist[S] = 0;
        parent[S] = -1;
        while(!q.isEmpty()){
            int u = q.poll();
            if(u == D){
                break;
            }
            for(int v : adj[u]){
                if(dist[v] == -1){
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
        if(dist[D] == -1){
            pw.println(-1);
            pw.flush();
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int cur = D;
        while(cur != -1){
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);
        pw.println(dist[D]);
        for(int i = 0; i < path.size(); i++){
            if (i > 0){
                pw.print(" ");
            }
            pw.print(path.get(i));
        }
        pw.println();
        pw.flush();
    }
}