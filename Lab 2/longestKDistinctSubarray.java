import java.io.*;
public class longestKDistinctSubarray{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        String [] arr = br.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++){
            array[i] = Integer.parseInt(arr[i]);
        }
        int[] freq = new int[N+1];
        int left = 0;
        int maxLen = 0;
        int x = 0;
        for(int right = 0; right < N; right++){
            if (freq[array[right]] == 0){
                x++;
            }
            freq[array[right]]++;
            while(x > K){
                freq[array[left]]--;
                if (freq[array[left]] == 0){
                    x--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        pw.println(maxLen);
        pw.flush();
    }
}
