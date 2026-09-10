import java.io.*;
import java.util.*;
public class HelpTheKing{
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static int[] parent, size;
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return false;
        }
        if(size[a] < size[b]){
            int temp = a; a = b; b = temp;
        }
        parent[b] = a;
        size[a] += size[b];
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a.w, b.w));
        parent = new int[N + 1];
        size = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
            size[i] = 1;
        }
        long totalCost = 0;
        int usedEdges = 0;
        for(Edge e : edges){
            if(union(e.u, e.v)){
                totalCost += e.w;
                usedEdges++;
                if (usedEdges == N - 1){
                    break;
                }
            }
        }
        out.println(totalCost);
        out.flush();
    }
}
