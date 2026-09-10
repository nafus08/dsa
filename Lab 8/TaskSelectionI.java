import java.io.*;
import java.util.*;

public class TaskSelectionI{
    static class Task implements Comparable<Task> {
        int start, end;
        Task(int s, int e) { start = s; end = e; }
        public int compareTo(Task other) {
            return this.end - other.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[N];
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
            tasks[i] = new Task(s, e);
        }
        Arrays.sort(tasks);
        List<Task> selected = new ArrayList<>();
        int lastEnd = -1;
        for (Task t : tasks) {
            if (t.start >= lastEnd) {
                selected.add(t);
                lastEnd = t.end;
            }
        }
        out.println(selected.size());
        for (Task t : selected) {
            out.println(t.start + " " + t.end);
        }
        out.flush();
    }
}
