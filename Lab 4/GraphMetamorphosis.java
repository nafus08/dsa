import java.io.*;
public class GraphMetamorphosis{ 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++){
            String[] inputs = br.readLine().split(" ");
            int k = Integer.parseInt(inputs[0]);
            for (int j = 1; j <= k; j++){
                int v = Integer.parseInt(inputs[j]);
                matrix[i][v] = 1;
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                pw.print(matrix[i][j]);
                if (j < N - 1) pw.print(" ");
            }
            pw.println();
        }
        pw.flush();
    }
}