import java.io.*;
import java.util.*;
public class SevenBridges{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);
        int[] u = new int[M];
        int[] v = new int[M];
        String[] uline = br.readLine().split(" ");
        String[] vline = br.readLine().split(" ");
        int[] degree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++){
            u[i] = Integer.parseInt(uline[i]);
            v[i] = Integer.parseInt(vline[i]);
            degree[u[i]]++;
            degree[v[i]]++;
            graph[u[i]].add(v[i]);
            graph[v[i]].add(u[i]);
        }
        int start = -1;
        for(int i = 1; i <= N; i++){
            if(degree[i] > 0){
                start = i;
                break;
            }
        }
        if(start == -1){
            pw.println("YES");
            pw.flush();
            return;
        }
        boolean[] visited = new boolean[N + 1];
        dfs(start, graph, visited);
        for(int i = 1; i <= N; i++){
            if(degree[i] > 0 && !visited[i]){
                pw.println("NO");
                pw.flush();
                return;
            }
        }
        int odd = 0;
        for(int i = 1; i <= N; i++){
            if (degree[i] % 2 != 0) odd++;
        }
        if(odd == 0 || odd == 2){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        pw.flush();
    }
    static void dfs(int node, ArrayList<Integer>[] graph, boolean[] visited){
        visited[node] = true;
        for (int nxt : graph[node]){
            if (!visited[nxt]) dfs(nxt, graph, visited);
        }
    }
}