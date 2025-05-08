package demo.dsa1demos;

import dsa1.Stack;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class StackDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("Stack");
        Stack stack = new Stack();

        Map<String, Runnable> stackMap = new LinkedHashMap<>();

        stackMap.put("push(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter value to push> ", scanner);
            stack.push(a);
            System.out.println("\n" + stack.toString());
        });

        stackMap.put("pop()", () -> {
            Integer b = stack.pop();
            if (b != null) {
                System.out.println("\nItem popped: " + b);
                System.out.println("\n" + stack.toString());
            }
        });

        stackMap.put("peek()", () -> {
            Integer c = stack.peek();
            if (c != null)
                System.out.println("\nItem at end of stack: " + c);
            System.out.println("\n" + stack.toString());
        });

        stackMap.put("isEmpty()", () -> {
            System.out.println("\nStack empty? " + stack.isEmpty());
        });

        stackMap.put("toString()", () -> {
            System.out.println("\n" + stack.toString());
        });

        DemoUtil.runMenu("Stack methods", stackMap);
    }
}
