import java.io.*;
import java.util.*;
public class DiamondsUnderW{
    static int R, H;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        H = Integer.parseInt(inputs[1]);
        grid = new char[R][H];
        visited = new boolean[R][H];
        for(int i = 0; i < R; i++){
            inputs = br.readLine().split("");
            for(int j = 0; j < H; j++){
                grid[i][j] = inputs[j].charAt(0);
            }
        }
        int maxDiamonds = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < H; j++){
                if(!visited[i][j] && grid[i][j] != '#'){
                    maxDiamonds = Math.max(maxDiamonds, bfs(i, j));
                }
            }
        }
        pw.println(maxDiamonds);
        pw.flush();
    }
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int diamonds = grid[x][y] == 'D' ? 1 : 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int cx = node[0], cy = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx >= 0 && nx < R && ny >= 0 && ny < H && !visited[nx][ny] && grid[nx][ny] != '#'){
                    visited[nx][ny] = true;
                    if (grid[nx][ny] == 'D'){
                        diamonds++;
                    }
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return diamonds;
    }
}