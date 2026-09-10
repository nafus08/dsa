import java.io.*;
public class CountTheInversion{
    static long inversionCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int [] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        int [] aux = new int[N];
        mergeSortInPlace(arr, aux, 0, N - 1);
        pw.println(inversionCount);
        for (int i = 0; i < N; i++){
            pw.print(arr[i] + " ");
        }
        pw.println();
        pw.flush();
    }
    public static void mergeSortInPlace(int[] arr, int[] aux, int l, int r){
        if (l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSortInPlace(arr, aux, l, mid);
        mergeSortInPlace(arr, aux, mid + 1, r);
        mergeRanges(arr, aux, l, mid, r);
    }
    public static void mergeRanges(int[] arr, int[] aux, int l, int mid, int r){
        int i = l;
        int j = mid + 1;
        int k = l;
        for(int idx = l; idx <= r; idx++){
            aux[idx] = arr[idx];
        }
        i = l;
        j = mid + 1;
        while(i <= mid && j <= r) {
            if(aux[i] <= aux[j]){
                arr[k++] = aux[i++];
            } 
            else{
                arr[k++] = aux[j++];
                inversionCount += (mid - i + 1);
            }
        }
        while(i <= mid){
            arr[k++] = aux[i++];
        }
        while(j <= r){
            arr[k++] = aux[j++];
        }
    }
}
