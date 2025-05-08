package dsa2;

public class MinPriorityQueue {
    private static MinHeap minheap = new MinHeap(10);

    public static void add(String value, int priority) {
        minheap.insert(priority, value);
    }

    public static String remove() {
        return minheap.remove();
    }   

    public static boolean isEmpty() {
        return minheap.isEmpty();
    }
}
