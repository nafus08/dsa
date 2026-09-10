import java.io.*;
public class longestSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        String [] arr = br.readLine().split(" ");
        int [] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        int left = 0;
        int sum = 0;
        int maxLen = 0;
        for (int right = 0; right < N; right++) {
            sum += array[right];
            while (sum > K && left <= right) {
                sum -= array[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        pw.println(maxLen);
        pw.flush();
    }
}