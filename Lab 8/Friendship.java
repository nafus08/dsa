import java.io.*;
import java.util.*;
public class Friendship{
    static int[] parent;
    static int[] size;
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static int union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return size[pa];
        }
        if(size[pa] < size[pb]){
            int temp = pa;
            pa = pb;
            pb = temp;
        }
        parent[pb] = pa;
        size[pa] += size[pb];
        return size[pa];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        size = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
            size[i] = 1;
        }
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = union(a, b);
            out.append(ans).append('\n');
        }
        System.out.print(out.toString());
    }
}
