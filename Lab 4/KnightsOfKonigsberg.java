import java.io.*;
public class KnightsOfKonigsberg{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(firstLine[2]);
        boolean[][] board = new boolean[N + 1][M + 1];
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[][] knights = new int[K][2];
        for (int i = 0; i < K; i++) {
            String[] pos = br.readLine().split(" ");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            knights[i][0] = x;
            knights[i][1] = y;
            board[x][y] = true;
        }
        boolean attack = false;
        outer:
        for (int i = 0; i < K; i++){
            int x = knights[i][0];
            int y = knights[i][1];
            for(int j = 0; j < 8; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(board[nx][ny]){
                        attack = true;
                        break outer;
                    }
                }
            }
        }
        if(attack){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        pw.flush();
    }
}
