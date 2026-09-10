import java.io.*;
public class oddoreven{
    public static void main(String [] args) throws NumberFormatException, IOException{
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(bw.readLine());
        int [] array = new int[N];
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(bw.readLine());
            array[i] = num;
        }
        for(int i = 0; i < N; i++){
            if(array[i] % 2 == 0){
                pw.println(array[i] + " is an Even number.");
                pw.flush();
            }
            else{
                pw.println(array[i] + " is an Odd number.");
                pw.flush();
            }
        }
    }
}