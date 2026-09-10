import java.io.*;
import java.util.*;
public class ThroughTheJungle{
    static ArrayList<Integer>[] g;
    static void bfs(int start, int n, int[] dist, int[] parent){
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : g[u]){
                if(dist[v] == -1){
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int S = Integer.parseInt(inputs[2]);
        int D = Integer.parseInt(inputs[3]);
        int K = Integer.parseInt(inputs[4]);
        g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            g[u].add(v);
        }

        int[] distS = new int[N+1];
        int[] parS  = new int[N+1];
        int[] distK = new int[N+1];
        int[] parK  = new int[N+1];
        bfs(S, N, distS, parS);
        bfs(K, N, distK, parK);
        if(distS[K] == -1 || distK[D] == -1){
            pw.println(-1);
            pw.flush();
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int cur = K;
        while(cur != S){
            path.add(cur);
            cur = parS[cur];
        }
        path.add(S);
        Collections.reverse(path);
        ArrayList<Integer> path2 = new ArrayList<>();
        cur = D;
        while(cur != K){
            path2.add(cur);
            cur = parK[cur];
        }
        path2.add(K);
        Collections.reverse(path2);
        for (int i = 1; i < path2.size(); i++) {
            path.add(path2.get(i));
        }
        pw.println(path.size() - 1);
        for (int x : path) pw.print(x + " ");
        pw.println();
        pw.flush();
    }
}