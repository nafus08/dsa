import java.io.*;
import java.util.*;
public class KingOfKonigsberg{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] pos = br.readLine().split(" ");
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        List<int[]> moves = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                moves.add(new int[]{nx, ny});
            }
        }
        moves.sort((a, b) -> {
            if (a[0] != b[0]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        pw.println(moves.size());
        for(int[] move : moves){
            pw.println(move[0] + " " + move[1]);
        }
        pw.flush();
    }
}