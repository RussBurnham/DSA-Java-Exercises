package dsa2;

public class MinHeap {
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] items;
    private int size;

    public MinHeap(int capacity) {
        items = new Node[capacity];
    }

    public void insert(int key, String value) {
        if (isFull()) {
            System.out.println("\nMinHeap full.");
            return;
        }

        items[size++] = new Node(key, value);

        bubbleUp();
    }

    public String remove() {
        if (isEmpty())
            return "MinHeap empty.";

        String root = items[0].value;
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index].key < items[parent(index)].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (index < size && !isValidParent(index)) {
            var smallerChildIndex = smallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = items[index].key <= leftChild(index).key;

        if (hasRightChild(index))
            isValid &= items[index].key <= rightChild(index).key;

        return isValid;
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index).key < rightChild(index).key) ? 
                    leftChildIndex(index) :
                    rightChildIndex(index);
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

    private Node leftChild(int index) {
        return items[index * 2 + 1];
    }

    private Node rightChild(int index) {
        return items[index * 2 + 2];
    }

    private void swap(int first, int second) {
        Node temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s | %s\n", "Key", "Value"));
        sb.append("----------------------\n");
        for (Node node : items) {
            if (node == null)
                break;
            sb.append(String.format("%-10d | %s\n", node.key, node.value));
        }
        return sb.toString();
    }
}