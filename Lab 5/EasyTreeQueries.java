import java.io.*;
import java.util.*;
public class EasyTreeQueries{
    static ArrayList<Integer>[] g;
    static int[] sub;
    static boolean[] vis;
    static void dfs(int u) {
        vis[u] = true;
        sub[u] = 1;
        for(int v : g[u]){
            if (!vis[v]){
                dfs(v);
                sub[u] += sub[v];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int R = Integer.parseInt(inputs[1]);
        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++){
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            g[u].add(v);
            g[v].add(u);
        }
        sub = new int[N + 1];
        vis = new boolean[N + 1];
        dfs(R);
        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0){
            int x = Integer.parseInt(br.readLine());
            pw.println(sub[x]);
        }
        pw.flush();
    }
}