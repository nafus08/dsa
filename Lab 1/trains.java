import java.io.*;
public class trains{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] lines = new String[N];
        String[] names = new String[N];
        int[] times = new int[N];
        int[] index = new int[N];
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            lines[i] = line;
            String[] parts = line.split(" ");
            names[i] = parts[0]; 
            String timeStr = parts[parts.length - 1];
            String[] t = timeStr.split(":");
            times[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            index[i] = i;
        }
        for (int i = 0; i < N - 1; i++){
            for (int j = 0; j < N - i - 1; j++){
                boolean swap = false;
                int cmp = names[j].compareTo(names[j + 1]);
                if (cmp > 0){
                    swap = true;
                }
                else if(cmp == 0){
                    if(times[j] < times[j + 1]){
                        swap = true;
                    }
                    else if(times[j] == times[j + 1] && index[j] > index[j + 1]){
                        swap = true;
                    }
                }
                if(swap){
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                    int tempTime = times[j];
                    times[j] = times[j + 1];
                    times[j + 1] = tempTime;
                    int tempIndex = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = tempIndex;
                    String tempLine = lines[j];
                    lines[j] = lines[j + 1];
                    lines[j + 1] = tempLine;
                }
            }
        }
        for(int i = 0; i < N; i++){
            pw.println(lines[i]);
        }
        pw.flush();
    }
}