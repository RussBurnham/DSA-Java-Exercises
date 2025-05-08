package demo.dsa1demos;

import dsa1.HashTable;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HashTableDemo implements Runnable{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("HashTable");
        int capacity = DemoUtil.getUserInt("\nEnter the capacity (number of buckets) for the map> ", scanner);
        HashTable map = new HashTable(capacity);

        Map<String, demo.Runnable> hashTableMenu = new LinkedHashMap<>();

        hashTableMenu.put("put(int key, String value)", () -> {
            int a = DemoUtil.getUserInt("\nEnter int key> ", scanner);
            String b = DemoUtil.getUserInput("\nEnter String value: ", scanner);
            map.put(a, b);
            System.out.println(map.toString());
        });

        hashTableMenu.put("remove(int key)", () -> {
            int c = DemoUtil.getUserInt("\nEnter int key to remove> ", scanner);
            map.remove(c);
            System.out.println(map.toString());
        });

        hashTableMenu.put("get(int key)", () -> {
            int d = DemoUtil.getUserInt("\nEnter int key to get its value> ", scanner);
            String result = map.get(d);
            if (result == "\nKey does not exist in this HashTable.")
                System.out.println(result);
            else
                System.out.println("\nValue: " + result);
        });

        hashTableMenu.put("toString()", () -> {
            System.out.println(map.toString());
        });

        DemoUtil.runMenu("HashTable methods", hashTableMenu);
    }
}
