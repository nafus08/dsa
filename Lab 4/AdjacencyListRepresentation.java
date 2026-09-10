import java.io.*;
public class AdjacencyListRepresentation{
    static class EdgeNode{
        int to;
        int weight;
        EdgeNode next;
        EdgeNode(int to, int weight){
            this.to = to;
            this.weight = weight;
            this.next = null;
        }
    }
    static EdgeNode[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        graph = new EdgeNode[N + 1];
        String [] second = br.readLine().split(" ");
        String [] third = br.readLine().split(" ");
        String [] fourth = br.readLine().split(" ");
        for (int i = 0; i < M; i++){
            int from = Integer.parseInt(second[i]);
            int to = Integer.parseInt(third[i]);
            int weight = Integer.parseInt(fourth[i]);
            EdgeNode node = new EdgeNode(to, weight);
            node.next = graph[from];
            graph[from] = node;
        }
        for (int i = 1; i <= N; i++){
            pw.print(i + ":");
            EdgeNode cur = graph[i];
            if (cur != null){
                pw.print(" ");
            } 
            boolean firstPrinted = false;
            while (cur != null){
                if (firstPrinted == false){
                    pw.print(" ");
                } 
                pw.print("(" + cur.to + "," + cur.weight + ")");
                firstPrinted = true;
                cur = cur.next;
            }
            pw.println();
        }
        pw.flush();
    }
}
