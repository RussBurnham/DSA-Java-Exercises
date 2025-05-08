package demo.dsa1demos;

import dsa1.Array;
import demo.DemoUtil;
import demo.Runnable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ArrayDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("Array");
        System.out.println("\n*Array length is 1. It will resize as necessary.");
        System.out.println("*Type (T) = Integer for the demo.");
        Array<Integer> array = new Array<>(1);
        Random random = new Random();

        Map<String, Runnable> arrayMenu = new LinkedHashMap<>();

        arrayMenu.put("insert(T item)", () -> {
            while (true) {
                System.out.print("\nPress ENTER to insert random Integer (enter any key to EXIT)> ");
                String input = scanner.nextLine();
                if (input.isBlank()) {
                    array.insert(random.nextInt(20));
                    System.out.println();
                    printArray(array);
                } else {
                    break;
                }
            }
        });

        arrayMenu.put("insertAt(T item, int index)", () -> {
            int a = DemoUtil.getUserInt("\nEnter index> ", scanner);
            int item = random.nextInt(10);
            if (a > array.getCount() || a < 0 ) {
                array.insertAt(item, a);
            } else {
                System.out.println("\nEntering random Integer '" + item + "' at index '" + a + "'.");
                array.insertAt(item, a);
                printArray(array);
            }
        });

        arrayMenu.put("removeAt(int index)", () -> {
            int b = DemoUtil.getUserInt("\nEnter index> ", scanner);
            array.removeAt(b);
            printArray(array);
        });

        arrayMenu.put("indexOf(T item)", () -> {
            printArray(array);
            int c = DemoUtil.getUserInt("\nEnter an Integer to get its index: ", scanner);
            System.out.println("\nIndex: " + array.indexOf(c) + "\n");
        });

        arrayMenu.put("contains(T item)", () -> {
            int d = DemoUtil.getUserInt("\nEnter Integer> ", scanner);
            System.out.println("\nArray contains " + d + "? " + array.contains(d) + "\n");
        });

        arrayMenu.put("print()", () -> {
            printArray(array);
        });

        DemoUtil.runMenu("Array methods", arrayMenu);
    }

    private void printArray(Array<Integer> array) {
        System.out.print("\nArray: ");
        array.print();
        System.out.println();
    }
    
}
