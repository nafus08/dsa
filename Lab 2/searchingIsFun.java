import java.io.*;
public class searchingIsFun{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while(T > 0){
            String [] parts = br.readLine().split(" ");
            int k = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            int result = k + (k - 1) / (x - 1);
            pw.println(result);
            T--;
        }
        pw.flush();
    }
}
