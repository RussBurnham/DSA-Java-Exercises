package dsa2;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class Graph {
    private class Node {
        private String label;

        private Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) {
            System.out.println("\nGraph does not contain this label.");
            return;
        }

        var toNode = nodes.get(to);
        if (toNode == null) {
            System.out.println("\nGraph does not contain this label.");
            return;
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);

        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            System.out.println("\nGraph does not contain this label.");
            return;
        }

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void printConnections() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected with " + targets);
        }
    }

    public void print() {
        System.out.println(adjacencyList);
    }

    public void depthFirstRecursive(String root) {
        Node rootNode = nodes.get(root);
        if (rootNode == null)
            return;

        depthFirstRecursive(rootNode, new HashSet<>());
    }

    private void depthFirstRecursive(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (Node neighbor : adjacencyList.get(root)) {
            if (!visited.contains(neighbor))
                depthFirstRecursive(neighbor, visited);
        }
    }

    public void depthFirstIterative(String root) {
        Node rootNode = nodes.get(root);
        if (rootNode == null)
            return;

        Stack<Node> callStack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        callStack.push(rootNode);
        while (!callStack.isEmpty()) {
            Node current = callStack.pop();
            if (!visited.contains(current)) {
                System.out.println(current);
                visited.add(current);
                for (Node neighbor : adjacencyList.get(current))
                    callStack.push(neighbor);
            }
        }
    }

    public void traverseBreadthFirst(String root) {
        Node rootNode = nodes.get(root);
        if (rootNode == null) {
            System.out.println("\nGraph does not contain this label.");
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.add(rootNode);
        visited.add(rootNode); 

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current);

            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor); 
                }
            }
        }
    }

    public List<String> topologicalSort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (Node node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty())
            sorted.add(stack.pop().label);
        
        return sorted;
    }

    private void topologicalSort(Node current, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(current))
            return;

        for (Node neighbor : adjacencyList.get(current))
            if (!visited.contains(neighbor))
                topologicalSort(neighbor, visited, stack);

        stack.push(current);
        visited.add(current);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all,
                            Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;

            if (visiting.contains(neighbour))
                return true;

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
