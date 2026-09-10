import java.io.*;

public class sortingAgain{
    static class Student{
        int id, mark, idx;
        Student(int id, int mark, int idx){
            this.id = id;
            this.mark = mark;
            this.idx = idx;
        }
    }
    static void mergeSort(Student[] arr, int l, int r){
        if (l >= r){
            return;
        } 
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    static void merge(Student[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];
        for (int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if (L[i].mark > R[j].mark || (L[i].mark == R[j].mark && L[i].id < R[j].id)){
                arr[k++] = L[i++];
            }
            else{
                arr[k++] = R[j++];
            }
        }
        while (i < n1){
            arr[k++] = L[i++];
        }
        while(j < n2){
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] idStr = br.readLine().split(" ");
            String[] markStr = br.readLine().split(" ");
            Student[] arr = new Student[N];
            for (int i = 0; i < N; i++){
                arr[i] = new Student(Integer.parseInt(idStr[i]), Integer.parseInt(markStr[i]), i);
            }
            mergeSort(arr, 0, N - 1);
            boolean[] visited = new boolean[N];
            int swaps = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i] || arr[i].idx == i){
                    continue;
                }
                int cycleSize = 0;
                int j = i;
                while (!visited[j]){
                    visited[j] = true;
                    j = arr[j].idx;
                    cycleSize++;
                }
                if (cycleSize > 1){
                    swaps += (cycleSize - 1);
                }
            }
            pw.println("Minimum swaps: " + swaps);
            for (int i = 0; i < N; i++){
                pw.println("ID: " + arr[i].id + " Mark: " + arr[i].mark);
            }
        }
        pw.flush();
    }
}