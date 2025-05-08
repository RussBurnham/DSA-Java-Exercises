package demo.dsa3demos;

import dsa3.SearchUtil;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

public class SearchDemo implements Runnable {
    private final int NANOSECONDS_PER_SECOND = 1_000_000_000;

    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void run() {
        DemoUtil.printHeader("SearchUtil");
        int[] sample = new int[20];
        for (int i = 0; i < sample.length; i++)
            sample[i] = i + 1;
        System.out.println("\nSample array for module: \n" + Arrays.toString(sample));

        Map<String, Runnable> searchMenu = new LinkedHashMap<>();

        addSearchOption(searchMenu, "linearSearch", SearchUtil::linearSearch, sample, scanner);
        addSearchOption(searchMenu, "binarySearch (iterative)", SearchUtil::binarySearch, sample, scanner);
        addSearchOption(searchMenu, "binarySearch (recursive)", SearchUtil::binarySearchRecursive, sample, scanner);
        addSearchOption(searchMenu, "ternarySearch (recursive)", SearchUtil::ternarySearch, sample, scanner);
        addSearchOption(searchMenu, "jumpSearch", SearchUtil::jumpSearch, sample, scanner);
        addSearchOption(searchMenu, "exponentialSearch", SearchUtil::exponentialSearch, sample, scanner);

        DemoUtil.runMenu("Search methods", searchMenu);
    }

    private void addSearchOption(Map<String, Runnable> menu, String label,
                                    BiFunction<int[], Integer, Integer> searchFunction,
                                    int[] sample, Scanner scanner) {
        menu.put(label, () -> {
            int target = DemoUtil.getUserInt("\nEnter target number in array> ", scanner);
            long start = System.nanoTime();
            int resultIndex = searchFunction.apply(sample, target);
            long end = System.nanoTime();
            long duration = end - start;
            double seconds = (double) duration / NANOSECONDS_PER_SECOND;

            System.out.println("\nIndex of " + target + ": " + resultIndex);
            System.out.println("\n" + label + " execution time: " + String.format("%.8f", seconds) + " seconds");
        });
    }
}
