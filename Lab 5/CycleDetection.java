import java.io.*;
import java.util.*;
public class CycleDetection{
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean[] recStack;
    static boolean hasCycle = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            graph[u].add(v);
        }
        visited = new boolean[N + 1];
        recStack = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                if (hasCycle) break;
            }
        }
        pw.println(hasCycle ? "YES" : "NO");
        pw.flush();
    }
    static void dfs(int node){
        visited[node] = true;
        recStack[node] = true;
        for(int neighbor : graph[node]){
            if(!visited[neighbor]){
                dfs(neighbor);
                if(hasCycle){
                    return;
                }
            }
            else if(recStack[neighbor]){
                hasCycle = true;
                return;
            }
        }
        recStack[node] = false;
    }
}