import java.io.*;
public class EdgeQueries{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] in = new int[N + 1];
        int[] out = new int[N + 1];
        String[] u = br.readLine().split(" ");
        String[] v = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            int from = Integer.parseInt(u[i]);
            int to = Integer.parseInt(v[i]);
            out[from]++;
            in[to]++;
        }
        for(int i = 1; i <= N; i++){
            pw.print((in[i] - out[i]) + " ");
        }
        pw.println();
        pw.flush();
    }
}