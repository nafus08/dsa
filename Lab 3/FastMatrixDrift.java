import java.io.*;
public class FastMatrixDrift{
    static final long MOD = 1000000007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String [] inputs = br.readLine().split(" ");
            long a11 = Long.parseLong(inputs[0]);
            long a12 = Long.parseLong(inputs[1]);
            long a21 = Long.parseLong(inputs[2]);
            long a22 = Long.parseLong(inputs[3]);
            long X = Long.parseLong(br.readLine());
            long [] result = matrixPower(a11, a12, a21, a22, X);
            pw.println(result[0] + " " + result[1]);
            pw.println(result[2] + " " + result[3]);
        }
        pw.flush();
    }
    public static long [] matrixPower(long a11, long a12, long a21, long a22, long exp) {
        long r11 = 1, r12 = 0, r21 = 0, r22 = 1;
        long m11 = a11, m12 = a12, m21 = a21, m22 = a22;
        while (exp > 0) {
            if ((exp & 1) == 1){
                long t11 = (r11 * m11 + r12 * m21) % MOD;
                long t12 = (r11 * m12 + r12 * m22) % MOD;
                long t21 = (r21 * m11 + r22 * m21) % MOD;
                long t22 = (r21 * m12 + r22 * m22) % MOD;
                r11 = t11; r12 = t12;
                r21 = t21; r22 = t22;
            }
            long t11 = (m11 * m11 + m12 * m21) % MOD;
            long t12 = (m11 * m12 + m12 * m22) % MOD;
            long t21 = (m21 * m11 + m22 * m21) % MOD;
            long t22 = (m21 * m12 + m22 * m22) % MOD;
            m11 = t11; m12 = t12;
            m21 = t21; m22 = t22;
            exp >>= 1;
        }
        return new long [] {r11, r12, r21, r22};
    }
}
