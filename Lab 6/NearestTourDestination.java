import java.io.*;
import java.util.*;
public class NearestTourDestination {
    static ArrayList<Integer>[] adj;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int S = Integer.parseInt(inputs[2]);
        int Q = Integer.parseInt(inputs[3]);
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        inputs = br.readLine().split(" ");
        int[] sources = new int[S];
        for (int i = 0; i < S; i++){
            sources[i] = Integer.parseInt(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        int[] destinations = new int[Q];
        for(int i = 0; i < Q; i++){
            destinations[i] = Integer.parseInt(inputs[i]);
        }
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        for(int src : sources){
            distance[src] = 0;
            queue.add(src);
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : adj[u]){
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    queue.add(v);
                }
            }
        }
        for(int i = 0; i < Q; i++){
            if(i > 0){
                pw.print(" ");
            }
            pw.print(distance[destinations[i]]);
        }
        pw.println();
        pw.flush();
    }
}