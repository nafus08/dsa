import java.io.*;
import java.util.*;
public class AncientOrdering{
    static int alph = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }
        ArrayList<Integer>[] graph = new ArrayList[alph];
        for (int i = 0; i < alph; i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[alph];
        boolean[] used = new boolean[alph];
        for(String word : words){
            for(char c : word.toCharArray()){
                used[c - 'a'] = true;
            }
        }
        boolean impossible = false;
        for(int i = 0; i < N - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean found = false;
            for(int j = 0; j < len; j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2){
                    graph[c1 - 'a'].add(c2 - 'a');
                    indegree[c2 - 'a']++;
                    found = true;
                    break;
                }
            }
            if (!found && w1.length() > w2.length()){
                impossible = true;
            }
        }
        if(impossible){
            pw.println(-1);
            pw.flush();
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < alph; i++) {
            if (used[i] && indegree[i] == 0) pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int u = pq.poll();
            sb.append((char) (u + 'a'));
            for(int v : graph[u]){
                indegree[v]--;
                if (indegree[v] == 0){
                    pq.add(v);
                }
            }
        }
        for(int i = 0; i < alph; i++){
            if(used[i] && sb.indexOf("" + (char) (i + 'a')) == -1){
                impossible = true;
                break;
            }
        }
        if(impossible){
            pw.println(-1);
        }
        else{
            pw.println(sb.toString());
        }
        pw.flush();
    }
}