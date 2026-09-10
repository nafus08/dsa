import java.io.*;
import java.util.*;
public class Advising{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        int[] arr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);
            graph[A].add(B);
            arr[B]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if (arr[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            order.add(u);
            for(int v : graph[u]){
                arr[v]--;
                if (arr[v] == 0){
                    q.add(v);
                }
            }
        }
        if(order.size() != N){
            pw.println("-1");
        }
        else{
            for(int i = 0; i < N; i++){
                if (i > 0){
                    pw.print(" ");
                }
                pw.print(order.get(i));
            }
            pw.println();
        }
        pw.flush();
    }
}