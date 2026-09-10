import java.io.*;
public class FastSeriesDrift{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String [] inputs = br.readLine().split(" ");
            long a = Long.parseLong(inputs[0]);
            long n = Long.parseLong(inputs[1]);
            long m = Long.parseLong(inputs[2]);
            long g = geoSum(a % m, n, m);
            long ans = ( (a % m) * g ) % m;
            pw.println(ans);
        }
        pw.flush();
    }
    static long geoSum(long a, long n, long m){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1 % m;
        }
        if((n & 1) == 0){
            long half = geoSum(a, n / 2, m);              
            long pow = modPow(a, n / 2, m);               
            return (half * ((1 + pow) % m)) % m;
        } 
        else{
            long prev = geoSum(a, n - 1, m);
            long add = modPow(a, n - 1, m);
            return (prev + add) % m;
        }
    }
    static long modPow(long base, long exp, long mod) {
        long res = 1 % mod;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
