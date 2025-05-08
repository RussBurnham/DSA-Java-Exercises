package dsa3;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortUtil {
    
    public static int[] bubbleSort(int[] array) {
        boolean notSorted = true;
        int range = array.length - 1;
        int index = 0;

        while (notSorted) {
            if (index >= range) 
                break;
            
            if (array[index] < array[index + 1]) {
                index++;  
            } else {
                for (int i = index; i < range; i++) 
                    if (array[i] > array[i + 1]) 
                        swap(array, i, i + 1);
                range--;
            }
        }

        return array;
    }
    
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < array.length; j++) 
            if (array[j] < array[minIndex]) 
            minIndex = j;
            
            if (minIndex != i)
            swap(array, i, minIndex);
        }
        
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int currentNum = array[i];
                int currentIndex = i;
                while (currentIndex > 0 && currentNum < array[currentIndex - 1]) {
                    array[currentIndex] = array[currentIndex - 1];
                    currentIndex--;
                }
                array[currentIndex] = currentNum;
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;

        int middleIndex = array.length / 2;

        int[] left = new int[middleIndex];
        for (int i = 0; i < middleIndex; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middleIndex];
        for (int i = middleIndex; i < array.length; i++)
            right[i - middleIndex] = array[i];
    
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right, array);
    }

    private static int[] merge(int[] left, int[] right, int[] mergedArray) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                mergedArray[k++] = left[i++];
            else
                mergedArray[k++] = right[j++];
        }

        while (i < left.length)
            mergedArray[k++] = left[i++];

        while (j < right.length)
            mergedArray[k++] = right[j++];

        return mergedArray;
    }

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int pivot = array[end];
        int boundary = start - 1;
        int index = start;

        while (index <= end) {
            if (array[index] <= pivot) {
                boundary++;
                if (array[boundary] > pivot) 
                    swap(array, boundary, index);
            }
            index++;
        }
        
        int leftSize = boundary - 1 - start;
        int rightSize = end - (boundary + 1);

        if (leftSize < rightSize) {
            quickSort(array, start, boundary - 1); 
            quickSort(array, boundary + 1, end); 
        } else {
            quickSort(array, boundary + 1, end); 
            quickSort(array, start, boundary - 1); 
        }
    }

    public static int[] countingSort(int[] array, int max) {
        int[] counts = new int[max + 1];

        for (int num : array) 
            counts[num]++;
        
        int k = 0;
        for (int i = 0; i < counts.length; i++) 
            for (int j = 0; j < counts[i]; j++)
                array[k++] = i;
        

        return array;
    }

    public static int[] bucketSort(int[] array, int numberOfBuckets) {
        var i = 0;
        for (var bucket: createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket) 
                array[i++] = item;
        }

        return array;
    }

    private static List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        int min = Arrays.stream(array).min().orElse(Integer.MIN_VALUE);
        int range = max - min + 1;

        for (int item : array) {
            int bucketIndex = (item - min) * numberOfBuckets / range;
            if (bucketIndex == numberOfBuckets) bucketIndex--; 
            buckets.get(bucketIndex).add(item);
        }

        return buckets;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
