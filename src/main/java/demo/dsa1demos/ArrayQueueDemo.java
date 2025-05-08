package demo.dsa1demos;

import dsa1.ArrayQueue;
import demo.DemoUtil;
import demo.Runnable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayQueueDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("ArrayQueue");
        ArrayQueue queue = new ArrayQueue();

        Map<String, Runnable> arrayQueueMenu = new LinkedHashMap<>();

        arrayQueueMenu.put("enqueue(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter value to enqueue> ", scanner);
            queue.enqueue(a);
            System.out.println(queue.toString());
        });

        arrayQueueMenu.put("dequeue()", () -> {
            queue.dequeue();
            System.out.println(queue.toString());
        });

        arrayQueueMenu.put("peek()", () -> {
            Integer c = queue.peek();
            if (c != null)
                System.out.println("\nFront of queue: " + queue.peek());
        });

        arrayQueueMenu.put("toString()", () -> {
            System.out.println(queue.toString());
        });

        DemoUtil.runMenu("ArrayQueue methods", arrayQueueMenu);
    }
}
