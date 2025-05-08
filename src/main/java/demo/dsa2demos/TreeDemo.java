package demo.dsa2demos;

import dsa2.Tree;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TreeDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("Tree");
        int a = DemoUtil.getUserInt("\nEnter the root number of the Tree> ", scanner);
        Tree tree = new Tree(a);

        Map<String, Runnable> treeMenu = new LinkedHashMap<>();

        treeMenu.put("insert(int value)", () -> {
            System.out.println("\nEnter a number to insert it, or any non-number key to exit> ");
            while (true) {
                System.out.print("Insert> ");
                String inputLine = scanner.nextLine();
                try {
                    int value = Integer.parseInt(inputLine);
                    tree.insert(value);
                    System.out.println("\nTree:\n");
                    System.out.println(tree.toString());
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("");
                    break;
                }
            }
        });

        treeMenu.put("contains(int value)", () -> {
            int b = DemoUtil.getUserInt("\nEnter value> ", scanner);
            System.out.println("\nTree contains " + b + "? " + tree.contains(b));
        });

        treeMenu.put("size()", () -> {
            System.out.println("\nTree size: " + tree.size());
        });

        treeMenu.put("height()", () -> {
            System.out.println("\nTree height: " + tree.height());
        });

        treeMenu.put("min()", () -> {
            System.out.println("\nMin: " + tree.min());
        });

        treeMenu.put("max()", () -> {
            System.out.println("\nMax: " + tree.min());
        });

        treeMenu.put("countLeaves()", () -> {
            System.out.println("\nLeaf count: " + tree.countLeaves());
        });

        treeMenu.put("areSiblings(int value1, int value2)", () -> {
            int c = DemoUtil.getUserInt("\nEnter value 1> ", scanner);
            int d = DemoUtil.getUserInt("\nEnter value 2> ", scanner);
            System.out.println("\nAre " + c + " and " + d +
                    " siblings? " + tree.areSiblings(c, d));
        });

        treeMenu.put("getAncestors(int value)", () -> {
            int e = DemoUtil.getUserInt("\nEnter value> ", scanner);
            System.out.println("Ancestors: " + tree.getAncestors(e));
        });

        treeMenu.put("traversePreOrder()", () -> {
            System.out.println("\nPre-Order Traversal: ");
            tree.traversePreOrder();
            System.out.println();
        });

        treeMenu.put("traverseInOrder()", () -> {
            System.out.println("\nIn-Order Traversal: ");
            tree.traverseInOrder();
            System.out.println();
        });

        treeMenu.put("traversePostOrder()", () -> {
            System.out.println("\nPost-Order Traversal: ");
            tree.traversePostOrder();
            System.out.println();
        });

        treeMenu.put("traverseLevelOrder()", () -> {
            System.out.println("\nLevel-Order Traversal: ");
            tree.traverseLevelOrder();
        });

        treeMenu.put("isBalanced()", () -> {
            System.out.println("\nTree is balanced? " + tree.isBalanced());
        });

        treeMenu.put("isPerfect()", () -> {
            System.out.println("\nTree is perfect? " + tree.isPerfect());
        });

        treeMenu.put("isBinarySearchTree()", () -> {
            System.out.println("\nIs Tree a Binary Search Tree? " + tree.isBinarySearchTree());
        });

        treeMenu.put("getNodesAtDistance(int value)", () -> {
            int f = DemoUtil.getUserInt("\nEnter distance> ", scanner);
            System.out.println("\nNodes at distance " + f + ":");
            System.out.println(tree.getNodesAtDistance(f));
        });

        DemoUtil.runMenu("Tree methods", treeMenu);
    }
}
