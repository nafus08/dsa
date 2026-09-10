import java.io.*;
public class OrderingBinaryTree{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String [] inputs = br.readLine().split(" ");
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        printBSTOrder(arr, 0, N - 1, pw);
        pw.println();
        pw.flush();
    }
    public static void printBSTOrder(int [] arr, int left, int right, PrintWriter pw) {
        if (left > right){
            return;
        }
        int mid = (left + right) / 2;
        pw.print(arr[mid] + " ");
        printBSTOrder(arr, left, mid - 1, pw);
        printBSTOrder(arr, mid + 1, right, pw);
    }
}