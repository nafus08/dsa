import java.io.*;
public class beautifulSortedList{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String [] A = br.readLine().split(" ");
        int [] aliceArr = new int [N];
        for(int i = 0; i < N; i++){
            aliceArr[i] = Integer.parseInt(A[i]);
        }
        int M = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        int [] bobArr = new int [M];
        for(int i = 0; i < M; i++){
            bobArr [i] = Integer.parseInt(B[i]);
        }
        int i = 0;
        int j = 0;
        while(i < N && j < M){
            if (aliceArr[i] <= bobArr[j]){
                pw.print(aliceArr[i] + " ");
                i++;
            } 
            else{
                pw.print(bobArr[j] + " ");
                j++;
            }
        }
        while(i < N){
            pw.print(aliceArr[i] + " ");
            i++;
        }
        while(j < M){
            pw.print(B[j] + " ");
            j++;
        }
        pw.flush();
    }
}
