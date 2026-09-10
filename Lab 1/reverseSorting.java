import java.io.*;
import java.util.*;

public class reverseSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(parts[i]);
        }

        if (isSorted(A)) {
            pw.println("YES");
            pw.println(0);
            return;
        }

        if (N < 3) {
            pw.println("NO");
            return;
        }

        List<int[]> ops = new ArrayList<>();

       
        for (int i = 0; i < N - 2; i++) {
           
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (A[j] < A[minIndex]) minIndex = j;
            }

           
            while (minIndex - i >= 2) {
                reverse3(A, minIndex - 2);
                ops.add(new int[]{minIndex - 2 + 1, minIndex - 2 + 3}); 
                minIndex -= 2;
            }

          
            if (minIndex - i == 1) {
             
                reverse3(A, i);
                ops.add(new int[]{i + 1, i + 3});
                reverse3(A, i);
                ops.add(new int[]{i + 1, i + 3});
            }
        }

        if (isSorted(A)) {
            pw.println("YES");
            pw.println(ops.size());
            for (int[] op : ops) {
                pw.println(op[0] + " " + op[1]);
            }
        } else {
            pw.println("NO");
        }
    }

    static void reverse3(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 2];
        arr[i + 2] = temp;
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
