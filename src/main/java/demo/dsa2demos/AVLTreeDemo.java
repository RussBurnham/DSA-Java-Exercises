package demo.dsa2demos;

import dsa2.AVLTree;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

public class AVLTreeDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("AVLTree");
        System.out.println("\nWatch the AVLTree grow and rotate as you insert items.");

        AVLTree tree = new AVLTree();
        Map<String, Runnable> treeMenu = new LinkedHashMap<>();

        treeMenu.put("insert(int value)", () -> {
            System.out.println("\nEither enter an integer to INSERT or leave blank to EXIT:");

            while (true) {
                System.out.print("Insert> ");
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    break; 
                }

                try {
                    int value = Integer.parseInt(line);
                    tree.insert(value);
                    System.out.println("\nAVLTree:\n");
                    tree.print();
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("");
                }
            }
        });

        treeMenu.put("traverseInOrder()", () -> {
            System.out.println("In-Order Traversal: ");
            tree.traverseInOrder();
        });
        

        DemoUtil.runMenu("AVLTree methods", treeMenu);
    }
}
