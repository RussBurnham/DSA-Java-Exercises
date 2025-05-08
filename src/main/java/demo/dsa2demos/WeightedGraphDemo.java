package demo.dsa2demos;

import dsa2.WeightedGraph;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WeightedGraphDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("WeightedGraph");
        WeightedGraph graph = new WeightedGraph();

        Map<String, Runnable> weightedGraphMenu = new LinkedHashMap<>();

        weightedGraphMenu.put("addNode(String label)", () -> {
            while (true) {
                String a = DemoUtil.getUserInput("\nEnter label or leave blank to EXIT> ", scanner);
                if (a.isBlank())
                    break;
                graph.addNode(a);
            }
        });

        weightedGraphMenu.put("addEdge(String from, String to, int weight)", () -> {
            while (true) {
                String b = DemoUtil.getUserInput("\nEnter label (from) or leave blank to EXIT> ", scanner);
                if (b.isBlank())
                    break;
                String c = DemoUtil.getUserInput("\nEnter label (to)> ", scanner);
                int d = DemoUtil.getUserInt("\nEnter weight> ", scanner);
                graph.addEdge(b, c, d);
                System.out.println("\nConnections: ");
                graph.printConnections();
            }
        });

        weightedGraphMenu.put("getShortestDistance(String from, String to)", () -> {
            String e = DemoUtil.getUserInput("\nEnter label (from)> ", scanner);
            String f = DemoUtil.getUserInput("\nEnter label (to)> ", scanner);
            System.out.println("\nShortest distance: " + graph.getShortestDistance(e, f));
        });

        weightedGraphMenu.put("getShortestPath(String from, String to)", () -> {
            String g = DemoUtil.getUserInput("\nEnter label (from)> ", scanner);
            String h = DemoUtil.getUserInput("\nEnter label (to)> ", scanner);
            System.out.println("\nShortest path: " + graph.getShortestPath(g, h));
        });

        weightedGraphMenu.put("getMinimumSpanningTree()", () -> {
            System.out.println("\nMinimum spanning Tree: ");
            WeightedGraph min = graph.getMinimumSpanningTree();
            min.printConnections();
            System.out.println();
        });

        weightedGraphMenu.put("hasCycle()", () -> {
            System.out.println("\nWeightedGraph has a cycle? " + graph.hasCycle());
        });

        weightedGraphMenu.put("containsNode(String label)", () -> {
            String i = DemoUtil.getUserInput("\nEnter label> ", scanner);
            System.out.println("\nWeightedGraph contains node? " + graph.containsNode(i));
        });

        weightedGraphMenu.put("printConnections()", () -> {
            System.out.println("\nConnections: ");
            graph.printConnections();
            System.out.println();
        });

        DemoUtil.runMenu("WeightedGraph methods", weightedGraphMenu);
    }

}
