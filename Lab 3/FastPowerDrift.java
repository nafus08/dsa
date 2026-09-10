import java.io.*;
public class FastPowerDrift{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String [] inputs = br.readLine().trim().split(" ");
        long a = Long.parseLong(inputs[0]);
        long b = Long.parseLong(inputs[1]);
        long MOD = 107;
        pw.println(modPow(a % MOD, b, MOD));
        pw.flush();
    }
    static long modPow(long base, long exp, long mod){
        long result = 1 % mod;
        while (exp > 0) {
            if ((exp & 1) == 1){
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
