package demo.dsa3demos;

import dsa3.SortUtil;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class SortDemo implements Runnable {
    private final int NANOSECONDS_PER_SECOND = 1_000_000_000;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
         DemoUtil.printHeader("SortUtil");

        Map<String, Runnable> sortMenu = new LinkedHashMap<>();
        
        addSortOption(sortMenu, "bubbleSort", SortUtil::bubbleSort, scanner);
        addSortOption(sortMenu, "selectionSort", SortUtil::selectionSort, scanner);
        addSortOption(sortMenu, "insertionSort", SortUtil::insertionSort, scanner);
        addSortOption(sortMenu, "mergeSort", SortUtil::mergeSort, scanner);
        addSortOption(sortMenu, "quickSort", SortUtil::quickSort, scanner);
        
        sortMenu.put("countingSort", () -> {
            int[] array = sampleArrays(scanner);
            System.out.println(Arrays.toString(array));
            int[] sortedArray = SortUtil.quickSort(array);
            int max = sortedArray[sortedArray.length - 1];
            long start = System.nanoTime();
            var countingSortArray = SortUtil.countingSort(array, max);
            long end = System.nanoTime();
            long duration = end - start;
            double seconds = (double) duration / NANOSECONDS_PER_SECOND;
            System.out.println("\ncountingSort execution time: " + String.format("%.8f", seconds) + " seconds");
            System.out.println("\nSorted array: " + Arrays.toString(countingSortArray));
        });

        sortMenu.put("bucketSort", () -> {
            int[] array2 = sampleArrays(scanner);
            System.out.println(Arrays.toString(array2));
            long start2 = System.nanoTime();
            var sortedArray2 = SortUtil.bucketSort(array2, 3);
            long end2 = System.nanoTime();
            long duration2 = end2 - start2;
            double seconds2 = (double) duration2 / NANOSECONDS_PER_SECOND;
            System.out.println("\nbucketSort(3 buckets used) execution time: "
                                    + String.format("%.8f", seconds2) + " seconds");
            System.out.println("\nSorted array: " + Arrays.toString(sortedArray2));
        });

        DemoUtil.runMenu("Sort methods", sortMenu);
    }

     private void addSortOption(Map<String, Runnable> menu, String label,
                                    Function<int[], int[]> searchFunction, Scanner scanner) {
        menu.put(label, () -> {
            int[] array = sampleArrays(scanner);
            System.out.println(Arrays.toString(array));
            long start = System.nanoTime();
            int[] sortedArray = searchFunction.apply(array);
            long end = System.nanoTime();
            long duration = end - start;
            double seconds = (double) duration / NANOSECONDS_PER_SECOND;
            System.out.println("\n" + label + " execution time: " + String.format("%.8f", seconds) + " seconds");
            System.out.println("\nSorted array: " + Arrays.toString(sortedArray));
        });
    }

    private int[] sampleArrays(Scanner scanner) {
        int[] arr1 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr3 = { 1, 10, 3, 5, 5, 6, 1, 0, 8, 10 };

        System.out.println("\n1 - " + Arrays.toString(arr1));
        System.out.println("2 - " + Arrays.toString(arr2));
        System.out.println("3 - " + Arrays.toString(arr3));

        System.out.println("\nChoose a sample array to sort (1, 2, 3)> ");

        String input = scanner.nextLine();

        try {
            int num = Integer.parseInt(input);

            if (num == 1)
                return arr1;
            if (num == 2)
                return arr2;
            if (num == 3)
                return arr3;

        } catch (NumberFormatException e) {
            System.out.println("");
        }

        System.out.println("Array = { }");
        return new int[0];
    }
    
}
