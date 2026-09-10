public class Task_3{

    public static void main(String[] args){
        
        int[] arr = {2, 4, 7, 1, 6};
        int m = 4;
        int[] array = taskProcess(arr, m);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }
    
    public static int[] taskProcess(int[] tasks, int m){

        MinHeap minHeap = new MinHeap(m);
        for (int i = 0; i < m; i++){
            minHeap.insert(0);
        }
        for (int i = 0; i < tasks.length; i++){
            int taskTime = tasks[i];
            int minLoad = minHeap.extractMin();
            minHeap.insert(minLoad + taskTime);
        }
        minHeap.sort();
        return minHeap.getHeapArray();

    }
    
}