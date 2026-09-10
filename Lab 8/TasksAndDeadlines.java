import java.io.*;
import java.util.*;
public class TasksAndDeadlines{
    static class Task{
        long a, d;
        Task(long a, long d){
            this.a = a;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            tasks[i] = new Task(a, d);
        }
        Arrays.sort(tasks, (t1, t2) -> Long.compare(t1.a, t2.a));
        long time = 0;
        long reward = 0;
        for(Task t : tasks){
            time += t.a;
            reward += (t.d - time);
        }
        out.println(reward);
        out.flush();
    }
}