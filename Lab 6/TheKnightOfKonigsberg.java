import java.io.*;
import java.util.*;
public class TheKnightOfKonigsberg{
    static class Cell{
        int x, y, dist;
        Cell(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int x1 = Integer.parseInt(inputs[0]) - 1;
        int y1 = Integer.parseInt(inputs[1]) - 1;
        int x2 = Integer.parseInt(inputs[2]) - 1;
        int y2 = Integer.parseInt(inputs[3]) - 1;
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        boolean[][] visited = new boolean[N][N];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(x1, y1, 0));
        visited[x1][y1] = true;
        int answer = -1;
        while(!queue.isEmpty()){
            Cell cur = queue.poll();
            if(cur.x == x2 && cur.y == y2){
                answer = cur.dist;
                break;
            }
            for(int i = 0; i < 8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new Cell(nx, ny, cur.dist + 1));
                }
            }
        }
        pw.println(answer);
        pw.flush();
    }
}