public class Task2b{
    
    static class EdgeNode{
        EdgeNode next;
        Object from;
        Object to;
        Object weight;

        public EdgeNode(Object from, Object to, Object weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.next = null;
        }
    }
    public static EdgeNode [] graph;
    public static void createGraph(int vertex){
        graph = new EdgeNode [vertex];
    }
    public static void addNode(int from, int to, int weight){
        Object f = (Object) from;
        Object t = (Object) to;
        Object w = (Object) weight;
        EdgeNode node = new EdgeNode(f, t, w);
        EdgeNode node2 = new EdgeNode(t, f, w);
        if(graph[from] == null){
            graph[from] = node;
        }
        else{
            EdgeNode n = graph[from];
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }
        if(graph[to] == null){
            graph[to] = node2;
        }
        else{
            EdgeNode n2 = graph[to];
            while(n2.next != null){
                n2 = n2.next;
            }
            n2.next = node2;
        }
    }
    public static void printGraph(){
        for(int i = 0; i < graph.length; i++){
            System.out.print("Vertex: " + i + " --> ");
            EdgeNode n = graph[i];
            while(n != null){
                System.out.print("(" + (int)n.from + ", " + (int)n.to + ", " + (int)n.weight + ")" + " --> ");
                n = n.next;
            }
            System.out.println();
        }
    }
    public static void maxSumFinder(){
        int sum = 0;
        int vertex = 0;
        int maxSum = 0;
        for(int i = 0; i < graph.length; i++){
            sum = 0;
            EdgeNode n = graph[i];
            while(n != null){
                sum += (int) n.weight;
                n = n.next;
            }
            if(sum > maxSum){
                maxSum = sum;
                vertex = i;
            }
        }
        System.out.println("Vertex: " + vertex + " Sum: " + maxSum);
    }
    public static void main(String [] args){
        createGraph(7);
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
        maxSumFinder();
    }
}