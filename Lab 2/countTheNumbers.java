import java.io.*;
public class countTheNumbers{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int q = Integer.parseInt(inputs[1]);
        String [] arr = br.readLine().split(" ");
        int [] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        for(int i = 0; i < q; i++){
            String [] query = br.readLine().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);
            int left = lowerBound(array, x);
            int right = upperBound(array, y); 
            pw.println(right - left);
        }
        pw.flush();
    }
    static int lowerBound(int [] arr, int target){
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = (low + high) / 2;
            if (arr[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
