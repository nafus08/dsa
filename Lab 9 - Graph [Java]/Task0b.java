public class Task0b{
    
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
    public static void main(String [] args){
        createGraph(7);
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