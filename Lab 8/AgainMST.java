import java.io.*;
import java.util.*;
public class AgainMST{
    static class Edge{
        int u, v, w, id;
        Edge(int u, int v, int w, int id){
            this.u = u;
            this.v = v;
            this.w = w;
            this.id = id;
        }
    }
    static class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) parent[i] = i;
        }
        int find(int i){
            if(parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        boolean union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI != rootJ){
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] allEdges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            allEdges[i] = new Edge(u, v, w, i);
        }
        Arrays.sort(allEdges, (e1, e2) -> Integer.compare(e1.w, e2.w));
        DSU dsu = new DSU(n);
        long mstWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();
        int edgesUsed = 0;
        for(Edge e : allEdges){
            if(dsu.union(e.u, e.v)){
                mstWeight += e.w;
                mstEdges.add(e);
                edgesUsed++;
            }
        }
        if(edgesUsed != n - 1){
            System.out.println("-1");
            return;
        }
        long secondBestMST = Long.MAX_VALUE;
        boolean found = false;
        for(Edge removedEdge : mstEdges){
            DSU tempDsu = new DSU(n);
            long currentWeight = 0;
            int count = 0;
            for(Edge e : allEdges){
                if(e.id == removedEdge.id) continue;
                if(tempDsu.union(e.u, e.v)){
                    currentWeight += e.w;
                    count++;
                }
            }
            if(count == n - 1 && currentWeight > mstWeight){
                secondBestMST = Math.min(secondBestMST, currentWeight);
                found = true;
            }
        }
        System.out.println(found ? secondBestMST : -1);
    }
}