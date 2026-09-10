import java.io.*;
public class CoprimeGraph{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);
        int[][] neighbors = new int[N + 1][];
        for(int i = 1; i <= N; i++){
            int count = 0;
            for(int j = 1; j <= N; j++){
                if(i != j && gcd(i, j) == 1){
                    count++;
                }
            }
            neighbors[i] = new int[count];
            int idx = 0;
            for(int j = 1; j <= N; j++){
                if(i != j && gcd(i, j) == 1){
                    neighbors[i][idx++] = j;
                }
            }
        }
        for (int q = 0; q < Q; q++){
            String[] query = br.readLine().split(" ");
            int X = Integer.parseInt(query[0]);
            int K = Integer.parseInt(query[1]);
            if(K <= neighbors[X].length){
                pw.println(neighbors[X][K - 1]);
            }
            else{
                pw.println(-1);
            }
        }
        pw.flush();
    }
    private static int gcd(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}