import java.io.*;
public class CountTheInversionRevisited{
    static int answer = 0;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String [] inputs = br.readLine().split(" ");
        int [] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        mergeSort(arr);
        pw.println(answer);
        pw.flush();
    }
    public static int [] mergeSort(int [] arr){
        if (arr.length <= 1){
            return arr;
        }
        int mid = arr.length / 2;
        int [] left = new int[mid];
        int [] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    public static int [] merge(int [] left, int [] right){
        for (int x : left){
            if (x > 0){
                int t = (int)Math.sqrt(x - 1);
                int l = lowerBound(right, -t);
                int r = upperBound(right, t);
                answer += (r - l);
            }
        }
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < left.length){
            merged[k++] = left[i++];
        }
        while (j < right.length){
            merged[k++] = right[j++];
        }
        return merged;
    }
    public static int lowerBound(int[] arr, int val){
        int l = 0, r = arr.length;
        while (l < r){
            int mid = (l + r) / 2;
            if (arr[mid] < val){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
    public static int upperBound(int[] arr, int val){
        int l = 0, r = arr.length;
        while (l < r){
            int mid = (l + r) / 2;
            if (arr[mid] <= val){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
}