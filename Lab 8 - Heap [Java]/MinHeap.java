public class MinHeap {
    private int[] heap;
    private int size;
    private final int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity + 1]; // Index 0 is not used for easier calculations
        this.size = 0;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }
        
        size++;
        heap[size] = value;
        swim(size);
    }

    // Move element up to maintain heap property
    private void swim(int index) {
        while (index > 1 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Remove and return the minimum element
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        sink(1);
        return min;
    }

    // Move element down to maintain heap property
    private void sink(int index) {
        while (leftChild(index) <= size) {
            int smallerChild = leftChild(index);
            
            // Check if right child exists and is smaller than left child
            if (rightChild(index) <= size && heap[rightChild(index)] < heap[smallerChild]) {
                smallerChild = rightChild(index);
            }
            
            // If current element is smaller than both children, stop
            if (heap[index] <= heap[smallerChild]) {
                break;
            }
            
            swap(index, smallerChild);
            index = smallerChild;
        }
    }

    // Sort the heap array using heapsort
    public void sort() {
        int originalSize = size;
        
        // Build max heap by rearranging array
        for (int i = size / 2; i >= 1; i--) {
            sinkForSort(i, size);
        }
        
        // Extract elements one by one
        for (int i = size; i > 1; i--) {
            swap(1, i);
            sinkForSort(1, i - 1);
        }
        
        size = originalSize; // Restore original size
    }

    // Sink method specifically for heapsort (uses different size parameter)
    private void sinkForSort(int index, int heapSize) {
        while (leftChild(index) <= heapSize) {
            int largerChild = leftChild(index);
            
            if (rightChild(index) <= heapSize && heap[rightChild(index)] > heap[largerChild]) {
                largerChild = rightChild(index);
            }
            
            if (heap[index] >= heap[largerChild]) {
                break;
            }
            
            swap(index, largerChild);
            index = largerChild;
        }
    }

    // Helper methods for index calculations
    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Get the current heap array (for testing purposes)
    public int[] getHeapArray() {
        int[] result = new int[size];
        System.arraycopy(heap, 1, result, 0, size);
        return result;
    }

    // Get the size of the heap
    public int getSize() {
        return size;
    }

    // Display the heap (for testing purposes)
    public void display() {
        System.out.print("Heap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}