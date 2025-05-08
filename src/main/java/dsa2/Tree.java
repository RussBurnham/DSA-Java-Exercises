package dsa2;

import java.util.List;
import java.util.ArrayList;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public Tree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        Node node = new Node(value);

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value > current.value)
                current = current.rightChild;
            else if (value < current.value)
                current = current.leftChild;
            else
                return true;
        }
        return false;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;
        
        if (value < root.value)
            return contains(root.leftChild, value);
        else if (value > root.value)
            return contains(root.rightChild, value); 
        else
            return true;   
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.print(root.value + " ");
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // O(log n)
    public int min() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // O(n)
    // private int min(Node root) {
    //     if (root == null)
    //         return Integer.MAX_VALUE;

    //     if (isLeaf(root))
    //         return root.value;

    //     var left = min(root.leftChild);
    //     var right = min(root.rightChild);

    //     return Math.min(Math.min(left, right), root.value);
    // }

    private boolean isLeaf(Node node) {
        return (node.leftChild == null && node.rightChild == null);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        
        var left = max(root.leftChild);
        var right = max(root.rightChild);
        
        return Math.max(Math.max(left, right), root.value);
    }

    public boolean equals(Tree otherTree) {
        if (otherTree == null)
            return false;

        return equals(root, otherTree.root);
    }

    private boolean equals(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 != null)
            return (node1.value == node2.value) 
                && equals(node1.leftChild, node2.leftChild) 
                && equals(node1.rightChild, node2.rightChild);
        
        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return 
            isBinarySearchTree(root.leftChild, min, root.value - 1) &&
            isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (var value: getNodesAtDistance(i)) 
                System.out.println(value);    
        }
    }

    public int size() {
        return size(root);
    }
    
    private int size(Node root) {
        if (root == null)
            return 0;

        int count = size(root.leftChild) + size(root.rightChild) + 1;

        return count;
    }

    public int countLeaves() {
        return countLeaves(root);
    }
    
    private int countLeaves(Node root) {
        if (root == null)
            return 0;
        
        if (isLeaf(root))
            return 1;
        
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public boolean areSiblings(int value1, int value2) {
        return areSibling(root, value1, value2);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null)
            return false;

        boolean isCurrentSiblings = root.leftChild != null && root.rightChild != null &&
                ((root.leftChild.value == first && root.rightChild.value == second) ||
                        (root.rightChild.value == first && root.leftChild.value == second));

        return isCurrentSiblings ||
                areSibling(root.leftChild, first, second) ||
                areSibling(root.rightChild, first, second);

    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        if (getAncestors(root.leftChild, value, list) || getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;
        
        var balanceFactor = height(root.leftChild) - height(root.rightChild);

        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(root.leftChild) && 
                isBalanced(root.rightChild);
    }

    public boolean isPerfect() {
        return size() == Math.pow(2, height() + 1) - 1;
    }

    @Override
    public String toString() {
        if (root == null)
            return "\nTree empty.";

        StringBuilder sb = new StringBuilder();
        printTree(sb, root, "", true);
        return sb.toString();
    }

    private void printTree(StringBuilder sb, Node node, String prefix, boolean isTail) {
        if (node.rightChild != null)
            printTree(sb, node.rightChild, prefix + (isTail ? "│   " : "    "), false);

        sb.append(prefix)
                .append(isTail ? "└── " : "┌── ")
                .append(node.value)
                .append("\n");

        if (node.leftChild != null)
            printTree(sb, node.leftChild, prefix + (isTail ? "    " : "│   "), true);
    }
}
