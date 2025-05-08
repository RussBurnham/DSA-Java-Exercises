package dsa2;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class WeightedGraph {
    public class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        private Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        private Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " <---> " + to + " (" + weight + ")";
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            System.out.println("\nWeightedGraph node label does not exist.");
            return;
        }

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void printConnections() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty()) {
                for (Edge edge : edges) {
                    if (edge.from.label.compareTo(edge.to.label) < 0)
                        System.out.println(edge);
                }
            }
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        private NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return node + " (" + priority + ")";
        }
    }

    public class PathResult {
        private int distance;
        private Map<Node, Node> previousNodes;

        private PathResult(int distance, Map<Node, Node> previousNodes) {
            this.distance = distance;
            this.previousNodes = previousNodes;
        }

        public int getDistance() {
            return this.distance;
        }

        @Override
        public String toString() {
            return "" + distance;
        }
    }

    public PathResult getShortestDistance(String from, String to) {
        var start = nodes.get(from);
        var finish = nodes.get(to);
        if (start == null || finish == null) {
            System.out.println("\nWeightedGraph node label does not exist.");
            return null;
        }

        var distances = new HashMap<Node, Integer>();
        var visited = new HashSet<Node>();
        var queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(ne -> ne.priority));
        var previousNodes = new HashMap<Node, Node>();

        initialize(start, distances, queue, previousNodes);

        return getShortestDistance(finish, distances, visited, queue, previousNodes);
    }

    private void initialize(Node start, Map<Node, Integer> distances, 
                            PriorityQueue<NodeEntry> queue, Map<Node, Node> previousNodes) {
        for (Node node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);

        distances.replace(start, 0);
        queue.add(new NodeEntry(start, 0));
        previousNodes.put(start, null);
    }

    private PathResult getShortestDistance(Node finish, Map<Node, Integer> distances, 
                                    Set<Node> visited, PriorityQueue<NodeEntry> queue, 
                                    Map<Node, Node> previousNodes) {
        while (!queue.isEmpty()) {
            var current = queue.remove().node;

            if (current == finish)
                return new PathResult(distances.get(current), previousNodes);

            visited.add(current); 

            for (Edge edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                    previousNodes.put(edge.to, current);
                }
            }
        }

        return new PathResult(-1, new HashMap<Node, Node>());
    }

    public List<Node> getShortestPath(String from, String to) {
        PathResult pathResult = getShortestDistance(from, to);

        var path = new LinkedList<Node>();

        Node finish = nodes.get(to);
        while(finish != null) {
            path.addFirst(finish);
            finish = pathResult.previousNodes.get(finish);
        }

        return path;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, null, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node current, Node parent, Set<Node> visited) {
        visited.add(current);

        for (Edge edge : current.getEdges()) {
            if (edge.to == parent)
                continue;
            if (visited.contains(edge.to) || hasCycle(edge.to, current, visited))
                return true;
        }

        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        var tree = new WeightedGraph();

        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
            Comparator.comparingInt(e -> e.weight)
        );
        
        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for (var edge : nextNode.getEdges()) {
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
            }
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }
                    
}
