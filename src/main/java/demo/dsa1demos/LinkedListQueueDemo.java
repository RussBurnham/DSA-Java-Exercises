package demo.dsa1demos;

import dsa1.LinkedListQueue;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LinkedListQueueDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("LinkedListQueue");
        LinkedListQueue queue = new LinkedListQueue();

        Map<String, Runnable> linkedListQueueMenu = new LinkedHashMap<>();

        linkedListQueueMenu.put("enqueue(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter value to enqueue> ", scanner);
            queue.enqueue(a);
            System.out.println("\n" + queue.toString());
        });

        linkedListQueueMenu.put("dequeue()", () -> {
            queue.dequeue();
            System.out.println("\n" + queue.toString());
        });

        linkedListQueueMenu.put("peek()", () -> {
            Integer b = queue.peek();
            if (b != null)
                System.out.println("\nFront of queue: " + queue.peek());
        });

        linkedListQueueMenu.put("size()", () -> {
            System.out.println("\nLinkedListQueue size: " + queue.size());
        });

        linkedListQueueMenu.put("isEmpty()", () -> {
            System.out.println("\nLinkedListQueue empty? " + queue.isEmpty());
        });

        linkedListQueueMenu.put("toString()", () -> {
            System.out.println("\n" + queue.toString());
        });

        DemoUtil.runMenu("LinkedListQueue methods", linkedListQueueMenu);
    }
}
