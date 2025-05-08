package demo.dsa1demos;

import dsa1.LinkedList;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LinkedListDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("LinkedList");
        LinkedList linkedList = new LinkedList();

        Map<String, Runnable> linkedListMenu = new LinkedHashMap<>();

        linkedListMenu.put("addFirst(int item)", () -> {
            int a = DemoUtil.getUserInt("\nEnter a number to add at the beginning> ", scanner);
            linkedList.addFirst(a);
            System.out.println("\n" + Arrays.toString(linkedList.toArray()));
        });

        linkedListMenu.put("addLast(int item)", () -> {
            int b = DemoUtil.getUserInt("\nEnter a number to add at the end> ", scanner);
            linkedList.addLast(b);
            System.out.println("\n" + Arrays.toString(linkedList.toArray()));
        });

        linkedListMenu.put("removeFirst()", () -> {
            linkedList.removeFirst();
            System.out.println("\n" + Arrays.toString(linkedList.toArray()));
        });

        linkedListMenu.put("removeLast()", () -> {
            linkedList.removeLast();
            System.out.println("\n" + Arrays.toString(linkedList.toArray()));
        });

        linkedListMenu.put("contains(int item)", () -> {
            int c = DemoUtil.getUserInt("\nEnter a number> ", scanner);
            System.out.println("\nDoes the LinkedList contain this Integer? " +
                    linkedList.contains(c));
        });

        linkedListMenu.put("indexOf(int item)", () -> {
            int d = DemoUtil.getUserInt("\nEnter an index> ", scanner);
            Integer e = linkedList.indexOf(d);
            if (e != null)
                System.out.println("\nItem: " + e + ", is at index " + d);
            else
                System.out.println("\nIndex does not exist.");
        });

        linkedListMenu.put("reverse()", () -> {
            linkedList.reverse();
            System.out.println("\n" + Arrays.toString(linkedList.toArray()));
        });

        linkedListMenu.put("getKthFromTheEnd(int k)", () -> {
            int f = DemoUtil.getUserInt("\nEnter item's distance from the end> ", scanner);
            Integer g = linkedList.getKthFromTheEnd(f);
            if (g != null)
                System.out.println("\nItem = " + g);
        });

        DemoUtil.runMenu("LinkedList methods", linkedListMenu);
    }
    
}
