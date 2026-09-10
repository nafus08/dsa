public class Task2a{
     public static int [][] graph;
    public static void createGraph(int vertex, int edge){
        graph = new int [vertex][vertex];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                graph[i][j] = 0;
            }
        }
    }
    public static void addNode(int from, int to, int weight){
        graph[from][to] = weight;
        graph[to][from] = weight;
    }
    public static void printGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static String maxSumFinder(){
        int maxSum = 0;
        int vertex = 0;
        int sum = 0;
        for(int i = 0; i < graph.length; i++){
            sum = 0;
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] != 0){
                    sum += graph[i][j];
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                vertex = i;
            }
        }
        return "Index: "+ vertex +" Sum: "+ maxSum;
    }
    public static void main(String [] args){
        createGraph(7, 0);
        addNode(0, 2, 1);
        addNode(0, 4, 2);
        addNode(0, 5, 4);
        addNode(1, 4, 1);
        addNode(1, 5, 9);
        addNode(2, 3, 6);
        addNode(2, 4, 4);
        addNode(4, 5, 9);
        addNode(6, 0, 3);
        addNode(3, 6, 1);
        addNode(6, 1, 6);
        addNode(2, 6, 9);
        addNode(0, 1, 7);
        addNode(3, 0, 8);
        addNode(4, 6, 4);
        addNode(5, 3, 2);
        printGraph();
        System.out.println(maxSumFinder());
    }
}