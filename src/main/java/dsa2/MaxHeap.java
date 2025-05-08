package dsa2;

public class MaxHeap {
    private int[] items;
    private int size;

    public MaxHeap(int capacity) {
        items = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("\nMaxHeap full.");
            return;
        }

        items[size++] = value;

        bubbleUp();
    }

    public Integer remove() {
        if (isEmpty()) {
            System.out.println("\nMaxHeap empty.");
            return null;
        }

        int root = items[0];
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }
    
    public int max() {
        return items[0];
    }

    @Override
    public String toString() {
        if (size == 0)
            return "MaxHeap empty.";

        return buildTreeString(0, "", true);
    }

    private String buildTreeString(int index, String prefix, boolean isTail) {
        if (index >= size)
            return "";

        StringBuilder sb = new StringBuilder();

        int right = rightChildIndex(index);
        if (right < size)
            sb.append(buildTreeString(right, prefix + (isTail ? "│   " : "    "), false));

        sb.append(prefix)
                .append(isTail ? "└── " : "┌── ")
                .append(items[index])
                .append("\n");

        int left = leftChildIndex(index);
        if (left < size)
            sb.append(buildTreeString(left, prefix + (isTail ? "    " : "│   "), true));

        return sb.toString();
    }

    private void bubbleUp() {
        int index = size - 1;
        while(index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    
    private void bubbleDown() {
        int index = 0;
        while (index < size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = items[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid &= items[index] >= rightChild(index);

        return isValid;
    }
    
    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
        return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index) ?
                    leftChildIndex(index) : 
                    rightChildIndex(index));
    }
    
    private int parent(int index) {
        return (index - 1) / 2;
    }
        
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }
        
    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }
    
    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

}
