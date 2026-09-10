import java.io.*;
import java.util.*;
public class AFootballMatch{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            g[u].add(v);
            g[v].add(u);
        }
        int[] color = new int[N + 1];
        Arrays.fill(color, -1);
        int answer = 0;
        for(int start = 1; start <= N; start++){
            if(color[start] != -1){
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            color[start] = 0;
            int c0 = 0; 
            int c1 = 0;
            while(!q.isEmpty()){
                int u = q.poll();
                if (color[u] == 0){
                    c0++; 
                }
                else{
                    c1++;
                }
                for(int v : g[u]){
                    if(color[v] == -1){
                        color[v] = color[u] ^ 1;
                        q.add(v);
                    }
                }
            }
            answer += Math.max(c0, c1);
        }
        pw.println(answer);
        pw.flush();
    }
}