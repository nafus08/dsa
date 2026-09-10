public class Task_4{
    
    public static void main(String[] args){

        int[] arr = {4, 10, 2, 8, 6, 7};
        int k = 3;
        int[] array = findLargest(arr, k);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        
    }
    
    public static int[] findLargest(int[] arr, int k){

        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++){
            maxHeap.insert(arr[i]);
        }
        int[] array = new int[k];
        for (int i = 0; i < array.length; i++){
            array[i] = maxHeap.extractMax();
        }
        return array;

    }

}