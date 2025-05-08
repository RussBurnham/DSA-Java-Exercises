package demo.dsa2demos;

import dsa2.MinHeap;
import demo.DemoUtil;
import demo.Runnable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinHeapDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("MinHeap");
        int a = DemoUtil.getUserInt("\nEnter MinHeap capacity> ", scanner);
        MinHeap heap = new MinHeap(a);

        Map<String, Runnable> minHeapMenu = new LinkedHashMap<>();

        minHeapMenu.put("insert(int key, String value)", () -> {
            while (true) {
                System.out.print("\nEnter a number (or blank to stop)> ");
                String k = scanner.nextLine();
                if (k.isBlank())
                    break;
                String v = DemoUtil.getUserInput("\nEnter String value> ", scanner);

                try {
                    int key = Integer.parseInt(k);
                    heap.insert(key, v);
                    System.out.println("\nMinHeap:");
                    System.out.println(heap.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Try again.");
                }
            }
        });

        minHeapMenu.put("remove()", () -> {
            String removed = heap.remove();
            System.out.println("\nRemoved: " + removed);
            System.out.println("\nMinHeap:");
            System.out.println(heap.toString());
        });

        minHeapMenu.put("isEmpty()", () -> {
            System.out.println("\nMinHeap empty? " + heap.isEmpty());
        });

        minHeapMenu.put("isFull()", () -> {
            System.out.println("\nMinHeap full? " + heap.isFull());
        });

        DemoUtil.runMenu("MinHeap methods", minHeapMenu);
    }
    
}
