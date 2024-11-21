// Jvdroid-main: 
     public class Heap {
    private int[] data;  // Array to store heap elements
    private int size;    // Current number of elements
    private int capacity; // Maximum size of the heap

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(int key) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        data[size] = key; // Insert key at the end
        size++;
        heapifyUp(size - 1); // Restore heap property
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = data[0]; // The root is the maximum element
        data[0] = data[size - 1]; // Move the last element to the root
        size--;
        heapifyDown(0); // Restore heap property
        return max;
    }

    private void heapifyUp(int i) {
        while (i > 0 && data[parent(i)] < data[i]) {
            // Swap the current node with its parent
            int temp = data[parent(i)];
            data[parent(i)] = data[i];
            data[i] = temp;
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        // Check if the left child exists and is greater than the current node
        if (left < size && data[left] > data[largest]) {
            largest = left;
        }

        // Check if the right child exists and is greater than the largest so far
        if (right < size && data[right] > data[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and continue heapifying
        if (largest != i) {
            int temp = data[i];
            data[i] = data[largest];
            data[largest] = temp;
            heapifyDown(largest);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        System.out.println(heap.extractMax());  // Should return 30
    }
}      