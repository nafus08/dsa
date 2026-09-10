import java.io.*;
public class tripleTheTrouble{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String [] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int x = Integer.parseInt(first[1]);
        String [] arr = br.readLine().split(" ");
        int [] val = new int[n];
        int [] idx = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(arr[i]);
            idx[i] = i + 1;
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if (val[i] > val[j]) {
                    int tempVal = val[i];
                    val[i] = val[j];
                    val[j] = tempVal;
                    int tempIdx = idx[i];
                    idx[i] = idx[j];
                    idx[j] = tempIdx;
                }
            }
        }
        boolean bool = false;
        for(int i = 0; i < n - 2 && bool == false; i++) {
            int left = i + 1;
            int right = n - 1;
            int target = x - val[i];
            while(left < right){
                int sum = val[left] + val[right];
                if(sum == target){
                    pw.println(idx[i] + " " + idx[left] + " " + idx[right]);
                    bool = true;
                    break;
                } 
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        if (bool == false){
            pw.println(-1);
        }
        pw.flush();
    }
}