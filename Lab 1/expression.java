import java.io.*;
public class expression {
    public static void main(String [] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            String [] arr = str.split(" ");
            double num1 = Double.parseDouble(arr[1]);
            String oper = arr[2];
            double num2 = Double.parseDouble(arr[3]);
            double result = 0.0;
            if(oper.equals("+")){
                result = num1 + num2;
            }
            else if(oper.equals("-")){
                result = num1 - num2;
            }
            else if(oper.equals("*")){
                result = num1 * num2;
            }
            else{
                result = num1 / num2;
            }
            pw.println(result);
            pw.flush();
        }
    }
}
