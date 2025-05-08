package demo.dsa2demos;

import dsa2.Graph;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class GraphDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("Graph");
        Graph graph = new Graph();

        Map<String, Runnable> graphMenu = new LinkedHashMap<>();

        graphMenu.put("addNode(String label)", () -> {
            while (true) {
                String a = DemoUtil.getUserInput("\nEnter label (or blank to stop)> ", scanner);
                if (a.isBlank())
                    break;
                graph.addNode(a);
            }
        });

        graphMenu.put("addEdge(String from, String to)", () -> {
            while (true) {
                String b = DemoUtil.getUserInput("\nEnter label (from) (or blank to stop)> ", scanner);
                if (b.isBlank())
                    break;
                String c = DemoUtil.getUserInput("Enter label (to)> ", scanner);
                graph.addEdge(b, c);
            }
        });

        graphMenu.put("removeNode(String label)", () -> {
            String d = DemoUtil.getUserInput("\nEnter label to remove> ", scanner);
            graph.removeNode(d);
        });

        graphMenu.put("removeEdge(String from, String to)", () -> {
            String e = DemoUtil.getUserInput("\nEnter label (from)> ", scanner);
            String f = DemoUtil.getUserInput("\nEnter label (to)> ", scanner);
            graph.removeEdge(e, f);
        });

        graphMenu.put("traverseDepthFirst(String label)", () -> {
            String g = DemoUtil.getUserInput("\nEnter starting node label> ", scanner);
            System.out.println("\nDepth-First Search from '" + g + "':");
            graph.depthFirstRecursive(g);
            System.out.println();
        });

        graphMenu.put("traverseBreadthFirst(String label)", () -> {
            String h = DemoUtil.getUserInput("\nEnter starting node label> ", scanner);
            System.out.println("\nBreadth-First Traversal from '" + h + "':");
            graph.traverseBreadthFirst(h);
            System.out.println();
        });

        graphMenu.put("topologicalSort()", () -> {
            System.out.println("\nTopological sort: ");
            System.out.println(graph.topologicalSort());
        });

        graphMenu.put("hasCycle()", () -> {
            System.out.println("\nGraph has a cycle? " + graph.hasCycle());
        });

        graphMenu.put("printConnections()", () -> {
            System.out.println("\nConnections: ");
            graph.printConnections();
            System.out.println();
        });

        graphMenu.put("print()", () -> {
            System.out.println("\nGraph: ");
            graph.print();
            System.out.println();
        });

        DemoUtil.runMenu("Graph methods", graphMenu);
    }
}
