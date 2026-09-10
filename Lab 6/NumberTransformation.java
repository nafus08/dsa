import java.io.*;
import java.util.*;
public class NumberTransformation{
    static ArrayList<Integer>[] pf = new ArrayList[5001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        for(int i = 1; i <= 5000; i++){
            pf[i] = new ArrayList<>();
        }
        sievePrimeFactors();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String[] inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int t = Integer.parseInt(inputs[1]);
            int ans = bfs(s, t);
            pw.println(ans);
        }
        pw.flush();
    }

    static void sievePrimeFactors(){
        int[] spf = new int[5001];
        for(int i = 2; i <= 5000; i++){
            if(spf[i] == 0){
                for(int j = i; j <= 5000; j += i){
                    spf[j] = i;
                }
            }
        }
        for(int i = 2; i <= 5000; i++){
            int x = i;
            while (x > 1){
                int p = spf[x];
                if (p != i) pf[i].add(p);
                while (x % p == 0){
                    x /= p;
                }
            }
        }
    }
    static int bfs(int s, int t){
        if (s == t){
            return 0;
        }
        int[] dist = new int[5001];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int p : pf[u]){
                int v = u + p;
                if (v > t){
                    continue;
                }
                if(dist[v] == -1){
                    dist[v] = dist[u] + 1;
                    if (v == t){
                        return dist[v];
                    }
                    q.add(v);
                }
            }
        }
        return -1;
    }
}