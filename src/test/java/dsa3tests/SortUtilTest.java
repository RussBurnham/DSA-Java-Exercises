package dsa3tests;

import dsa3.SortUtil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortUtilTest {

    @Test
    void testBubbleSort() {
        int[] input = { 5, 3, 1, 4, 2 };
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, SortUtil.bubbleSort(input));
    }

    @Test
    void testSelectionSort() {
        int[] input = { 9, 2, 4, 6, 1 };
        int[] expected = { 1, 2, 4, 6, 9 };
        assertArrayEquals(expected, SortUtil.selectionSort(input));
    }

    @Test
    void testInsertionSort() {
        int[] input = { 4, 3, 2, 10, 12, 1, 5, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 10, 12 };
        assertArrayEquals(expected, SortUtil.insertionSort(input));
    }

    @Test
    void testMergeSort() {
        int[] input = { 38, 27, 43, 3, 9, 82, 10 };
        int[] expected = { 3, 9, 10, 27, 38, 43, 82 };
        assertArrayEquals(expected, SortUtil.mergeSort(input));
    }

    @Test
    void testQuickSort() {
        int[] input = { 10, 7, 8, 9, 1, 5 };
        int[] expected = { 1, 5, 7, 8, 9, 10 };
        assertArrayEquals(expected, SortUtil.quickSort(input));
    }

    @Test
    void testCountingSort() {
        int[] input = { 4, 2, 2, 8, 3, 3, 1 };
        int[] expected = { 1, 2, 2, 3, 3, 4, 8 };
        assertArrayEquals(expected, SortUtil.countingSort(input, 8));
    }

    @Test
    void testBucketSort() {
        int[] input = { 42, 32, 33, 52, 37, 47, 51 };
        int[] expected = { 32, 33, 37, 42, 47, 51, 52 };
        assertArrayEquals(expected, SortUtil.bucketSort(input, 5));
    }

    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, SortUtil.bubbleSort(input.clone()));
        assertArrayEquals(expected, SortUtil.selectionSort(input.clone()));
        assertArrayEquals(expected, SortUtil.insertionSort(input.clone()));
        assertArrayEquals(expected, SortUtil.mergeSort(input.clone()));
        assertArrayEquals(expected, SortUtil.quickSort(input.clone()));
        assertArrayEquals(expected, SortUtil.countingSort(input.clone(), 0));
        assertArrayEquals(expected, SortUtil.bucketSort(input.clone(), 1));
    }

    @Test
    void testAlreadySortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, SortUtil.bubbleSort(input.clone()));
        assertArrayEquals(expected, SortUtil.selectionSort(input.clone()));
        assertArrayEquals(expected, SortUtil.insertionSort(input.clone()));
        assertArrayEquals(expected, SortUtil.mergeSort(input.clone()));
        assertArrayEquals(expected, SortUtil.quickSort(input.clone()));
        assertArrayEquals(expected, SortUtil.countingSort(input.clone(), 5));
        assertArrayEquals(expected, SortUtil.bucketSort(input.clone(), 3));
    }
}
