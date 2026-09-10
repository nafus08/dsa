import java.io.*;
public class solution{
    public static void main(String [] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            long N = Long.parseLong(br.readLine());
            long sum = (N * (N + 1)) / 2;
            pw.println(sum);
            pw.flush();
        } 
    }
}