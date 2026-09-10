import java.io.*;
public class twoSumRevisited{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(firstLine[2]);
        int[] A = new int[N];
        int[] B = new int[M];
        String[] arrA = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
             A[i] = Integer.parseInt(arrA[i]);
        }
        String[] arrB = br.readLine().split(" ");
        for (int j = 0; j < M; j++){
            B[j] = Integer.parseInt(arrB[j]);
        }
        int i = 0;
        int j = M - 1;
        int bestI = 1;
        int bestJ = 1;
        int minDif = Integer.MAX_VALUE;
        while (i < N && j >= 0) {
            int sum = A[i] + B[j];
            int dif = Math.abs(sum - K);
            if(dif < minDif){
                minDif = dif;
                bestI = i + 1;
                bestJ = j + 1;
            }
            if(sum < K){
                i++;
            }
            else{
                j--;
            }
        }
        pw.println(bestI + " " + bestJ);
        pw.flush();
    }
}