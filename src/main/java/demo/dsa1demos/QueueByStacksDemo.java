package demo.dsa1demos;

import dsa1.QueueByStacks;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class QueueByStacksDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("QueueByStacks");
        QueueByStacks queue = new QueueByStacks();

        Map<String, Runnable> queueByStacksMap = new LinkedHashMap<>();

        queueByStacksMap.put("enqueue(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter value to enqueue> ", scanner);
            queue.enqueue(a);
            System.out.println("\n" + queue.toString());
        });

        queueByStacksMap.put("dequeue()", () -> {
            Integer b = queue.dequeue();
            if (b != null) {
                System.out.println("\nItem removed: " + b);
                System.out.println("\n" + queue.toString());
            }
        });

        queueByStacksMap.put("peek()", () -> {
            Integer c = queue.peek();
            if (c != null)
                System.out.println("\nItem at front of queue: " + c);
        });

        queueByStacksMap.put("isEmpty()", () -> {
            System.out.println("\nQueueByStacks empty? " + queue.isEmpty());
            ;
        });

        queueByStacksMap.put("toString()", () -> {
            System.out.println("\n" + queue.toString());
        });

        DemoUtil.runMenu("QueueByStacks methods", queueByStacksMap);
    }
    
}
