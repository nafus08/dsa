import java.io.*;
public class ancientSorting{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(array[i]);
        }
        boolean swapped = true;
        while (swapped == true){
            swapped = false;
            for (int i = 0; i < N - 1; i++){
                if ((arr[i] % 2 == arr[i + 1] % 2) && (arr[i] > arr[i + 1])){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        pw.flush();
    }
}