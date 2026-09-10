import java.io.*;
public class twoSumTrouble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        String[] parts = br.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        int left = 0;
        int right = N - 1;
        boolean found = false;
        while (left < right) {
            int sumCheck = array[left] + array[right];
            if(sumCheck == S){
                pw.println((left + 1) + " " + (right + 1));
                found = true;
                break;
            } 
            else if(sumCheck < S){
                left++;
            } 
            else{
                right--;
            }
        }
        if (found == false){
            pw.println(-1);
        }
        pw.flush();
    }
}
