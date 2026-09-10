import java.io.*;
public class isSorted{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            String [] array = br.readLine().split(" ");
            int [] arr = new int [N];
            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(array[j]);
            }
            boolean bool = true;
            for(int j = 0; j < N - 1; j++){
                if(arr[j] > arr[j + 1]){
                    bool = false;
                    break;
                }
            }
            if(bool == true){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
            pw.flush();
        }
    }
}