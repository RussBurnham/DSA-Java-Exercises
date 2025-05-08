package dsa2;

public class HeapifierRecursive {
    public static void heapify(int[] array) {
        int lastParent = array.length / 2 - 1;
        for (int i = lastParent; i >= 0; i--) {
            heapify(i, array);
        }
    }

    private static void heapify(int index, int[] array) {
        int largerIndex = index;

        int leftChildIndex = index * 2 + 1;
        if (leftChildIndex < array.length && 
            array[leftChildIndex] > array[largerIndex])
            largerIndex = leftChildIndex;

        int rightChildIndex = index * 2 + 2;
        if (rightChildIndex < array.length && 
            array[rightChildIndex] > array[largerIndex])
            largerIndex = rightChildIndex;

        if (index == largerIndex)
            return;
        
        swap(array, index, largerIndex);
        heapify(largerIndex, array);
    }

    private static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int k, int[] array) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new MaxHeap(array.length);

        for (int number : array)
            heap.insert(number);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

}
