package dsa2;

public class PostOrderPracticeTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public void insert(int value) {
        root = insert(root, value);
        size++;
    }

    private Node insert(Node current, int value) {
        if (current == null)
            return new Node(value);

        if (current.leftChild != null && current.rightChild == null)
            current.rightChild = insert(current.rightChild, value);
        else
            current.leftChild = insert(current.leftChild, value);

        return current;
    }

    public int[] postOrder() {
        int[] items = new int[size];
        postOrder(root, items, 0);
        
        return items;
    }

    private int postOrder(Node current, int[] items, int index) {
        if (current == null)
            return index;

        index = postOrder(current.leftChild, items, index);
        index = postOrder(current.rightChild, items, index);

        items[index++] = current.value;

        return index;
    }
}
