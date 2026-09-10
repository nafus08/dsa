import java.io.*;
public class AdjacencyMatrixRepresentation{
    public static int [][] graph;
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String [] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        graph = new int [N][N];
        for(int i = 0; i < M; i++){
            String [] inp = br.readLine().split(" ");
            int r = Integer.parseInt(inp[0]);
            int c = Integer.parseInt(inp[1]);
            int edge = Integer.parseInt(inp[2]);
            graph [r-1][c-1] = edge;
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                pw.print(graph[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}