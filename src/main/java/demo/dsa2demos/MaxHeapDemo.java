package demo.dsa2demos;

import dsa2.MaxHeap;
import demo.DemoUtil;
import demo.Runnable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxHeapDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("MaxHeap");
        int a = DemoUtil.getUserInt("\nEnter MaxHeap capacity> ", scanner);
        MaxHeap heap = new MaxHeap(a);

        Map<String, Runnable> maxHeapMenu = new LinkedHashMap<>();

        maxHeapMenu.put("insert(int value)", () -> {
            while (true) {
                System.out.print("\nEnter an integer (or blank to stop)> ");
                String b = scanner.nextLine();
                if (b.isBlank())
                    break;

                try {
                    int value = Integer.parseInt(b);
                    heap.insert(value);
                    System.out.println(heap.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Try again.");
                }
            }
        });

        maxHeapMenu.put("remove()", () -> {
            Integer c = heap.remove();
            if (c != null) {
                System.out.println("\nRemoved: " + c);
                System.out.println(heap.toString());
            }
        });

        maxHeapMenu.put("isEmpty()", () -> {
            System.out.println("\nMaxHeap empty? " + heap.isEmpty());
        });

        maxHeapMenu.put("isFull()", () -> {
            System.out.println("\nMaxHeap full? " + heap.isFull());
        });

        maxHeapMenu.put("max()", () -> {
            System.out.println("\nMax value: " + heap.max());
        });
        
        DemoUtil.runMenu("MaxHeap methods", maxHeapMenu);
    }
}
