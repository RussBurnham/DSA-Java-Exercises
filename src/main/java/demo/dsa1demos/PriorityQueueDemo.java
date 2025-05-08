package demo.dsa1demos;

import dsa1.PriorityQueue;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class PriorityQueueDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("PriorityQueue");
        System.out.println("\n(This queue can only hold 5 int items.)");
        PriorityQueue queue = new PriorityQueue();

        Map<String, Runnable> priorityQueueMap = new LinkedHashMap<>();

        priorityQueueMap.put("add(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter value to add> ", scanner);
            queue.add(a);
            System.out.println("\n" + queue.toString());
        });

        priorityQueueMap.put("remove()", () -> {
            Integer b = queue.remove();
            if (b != null) {
                System.out.println("\n Item removed: " + b);
                System.out.println("\n" + queue.toString());
            }
        });

        priorityQueueMap.put("isFull()", () -> {
            System.out.println("\nPriorityQueue full? " + queue.isFull());
        });

        priorityQueueMap.put("isEmpty()", () -> {
            System.out.println("\nPriorityQueue empty? " + queue.isEmpty());
        });

        priorityQueueMap.put("toString()", () -> {
            System.out.println("\n" + queue.toString());
        });

        DemoUtil.runMenu("PriorityQueue methods", priorityQueueMap);
    }
    
}
