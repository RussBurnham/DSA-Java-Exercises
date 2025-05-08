package demo.dsa1demos;

import dsa1.StackByQueues;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StackByQueuesDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("StackByQueues");
        StackByQueues stack = new StackByQueues();

        Map<String, Runnable> stackByQueuesMap = new LinkedHashMap<>();

        stackByQueuesMap.put("push(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter value to push> ", scanner);
            stack.push(a);
            System.out.println("\n" + stack.toString());
        });

        stackByQueuesMap.put("pop()", () -> {
            Integer b = stack.pop();
            if (b != null) {
                System.out.println("\nItem popped: " + b);
                System.out.println("\n" + stack.toString());
            }
        });

        stackByQueuesMap.put("peek()", () -> {
            Integer c = stack.peek();
            if (c != null)
                System.out.println("\nItem at end of stack: " + c);
            System.out.println("\n" + stack.toString());
        });

        stackByQueuesMap.put("size()", () -> {
            System.out.println("\nStackByQueues size: " + stack.size());
        });

        stackByQueuesMap.put("isEmpty()", () -> {
            System.out.println("\nStackByQueues empty? " + stack.isEmpty());
        });

        stackByQueuesMap.put("toString()", () -> {
            System.out.println("\nStackByQueues: " + stack.toString());
        });

        DemoUtil.runMenu("StackByQueues methods", stackByQueuesMap);
    }
}
