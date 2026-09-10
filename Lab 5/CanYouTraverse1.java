import java.io.*;
import java.util.*;
public class CanYouTraverse1{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> bfsOrder = new ArrayList<>();
        visited[1] = true;
        queue.add(1);
        while(!queue.isEmpty()){
            int u = queue.poll();
            bfsOrder.add(u);
            for(int v : adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        for(int i = 0; i < bfsOrder.size(); i++){
            if(i > 0){
                pw.print(" ");
            }
            pw.print(bfsOrder.get(i));
        }
        pw.println();
        pw.flush();
    }
}
