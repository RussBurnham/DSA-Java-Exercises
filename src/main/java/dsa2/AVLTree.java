package dsa2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        private AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ("Value: " + value + " Height: " + height);
        }
    }

    public class NodeInfo {
        private int height;
        private int balance;

        private NodeInfo(AVLNode node) {
            this.height = height(node);
            this.balance = balanceFactor(node);
        }

        public int getHeight() {
            return this.height;
        }

        public int getBalance() {
            return this.balance;
        }
    }

    private AVLNode root; 

    public void insert(int value) {
        root = insert(root, value);
    }

    public int getRootValue() {
        return root != null ? root.value : -1;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public Map<Integer, NodeInfo> validateAVLTreeProperties() {
        Map<Integer, NodeInfo> properties = new LinkedHashMap<>();
        return validateAVLTreeProperties(root, properties);
    }

    private Map<Integer, NodeInfo> validateAVLTreeProperties(AVLNode current, Map<Integer, NodeInfo> properties) {
        if (current == null)
            return properties;
        
        validateAVLTreeProperties(current.leftChild, properties);
        NodeInfo info = new NodeInfo(current);
        properties.put(current.value, info);
        validateAVLTreeProperties(current.rightChild, properties);

        return properties;
    }

    private AVLNode insert(AVLNode current, int value) {
        if (current == null) 
            return new AVLNode(value);
        
        if (value < current.value) 
            current.leftChild = insert(current.leftChild, value);
        else 
            current.rightChild = insert(current.rightChild, value);

        setHeight(current);

        current = balance(current);
        
        return current;
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode rotateLeft(AVLNode node) {
        var newRoot = node.rightChild;
        
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode node) {
        var newRoot = node.leftChild;

        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private void traverseInOrder(AVLNode current) {
        if (current == null)
            return;

        traverseInOrder(current.leftChild);
        System.out.print(current.value + " ");
        traverseInOrder(current.rightChild);
    }

    public void print() {
        if (root == null) {
            System.out.println("\nAVLTree empty.");
            return;
        }
        
        int maxLevel = root.height + 1;
        printTopDown(List.of(root), 1, maxLevel);
    }

    private void printTopDown(List<AVLNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || allNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);
        List<AVLNode> newNodes = new ArrayList<>();
        for (AVLNode node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.leftChild);
                newNodes.add(node.rightChild);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines * 2 + i + 1);
                    continue;
                }

                if (nodes.get(j).leftChild != null)
                    System.out.print("/");
                else
                    System.out.print(" ");

                printWhitespaces(i * 2 - 1);

                if (nodes.get(j).rightChild != null)
                    System.out.print("\\");
                else
                    System.out.print(" ");

                printWhitespaces(edgeLines * 2 - i);
            }
            System.out.println();
        }

        printTopDown(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private boolean allNull(List<AVLNode> list) {
        for (AVLNode node : list)
            if (node != null)
                return false;
        return true;
    }
}
