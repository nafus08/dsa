public class Task0a{
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
    }
    public static void printGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        createGraph(7, 0);
        addNode(0, 2, 1);
        addNode(0, 4,1);
        addNode(0, 5, 1);
        addNode(1, 4, 1);
        addNode(1, 5, 1);
        addNode(2, 3, 1);
        addNode(2, 4, 1);
        addNode(4, 5, 1);
        addNode(6, 0, 1);
        addNode(3, 6, 1);
        addNode(6, 1, 1);
        addNode(2, 6, 1);
        addNode(0, 1, 1);
        addNode(3, 0, 1);
        addNode(4, 6, 1);
        addNode(5, 3, 1);
        printGraph();
    }
}