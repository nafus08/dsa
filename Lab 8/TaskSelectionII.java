import java.io.*;
import java.util.*;
public class TaskSelectionII {
    static class Task implements Comparable<Task> {
        int start, end;
        Task(int s, int e) { start = s; end = e; }
        public int compareTo(Task o) { return this.end - o.end; }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] parts = br.readLine().split(" ");
            int N = Integer.parseInt(parts[0]);
            int M = Integer.parseInt(parts[1]);
            Task[] tasks = new Task[N];
            for (int i = 0; i < N; i++) {
                parts = br.readLine().split(" ");
                int s = Integer.parseInt(parts[0]);
                int e = Integer.parseInt(parts[1]);
                tasks[i] = new Task(s, e);
            }
            Arrays.sort(tasks);
            TreeSet<Integer> available = new TreeSet<>();
            for (int i = 0; i < M; i++) available.add(0);
            int count = 0;
            for (Task t : tasks) {
                Integer freeTime = available.floor(t.start);
                if (freeTime != null) {
                    available.remove(freeTime); 
                    available.add(t.end);       
                    count++;
                }
            }
            out.println(count);
        }
        out.flush();
    }
}