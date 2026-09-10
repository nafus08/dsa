import java.io.*;
import java.util.*;
public class CanYouTraverse2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        inputs = br.readLine().split(" ");
        String[] inputs2 = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            int u = Integer.parseInt(inputs[i]);
            int v = Integer.parseInt(inputs2[i]);
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[N + 1];
        ArrayList<Integer> dfsOrder = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                visited[node] = true;
                dfsOrder.add(node);
                ArrayList<Integer> neighbors = graph[node];
                Collections.sort(neighbors, Collections.reverseOrder());
                for(int neighbor : neighbors){
                    if (!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }
        for(int i = 0; i < dfsOrder.size(); i++){
            if (i > 0){
                pw.print(" ");
            }
            pw.print(dfsOrder.get(i));
        }
        pw.println();
        pw.flush();
    }
}