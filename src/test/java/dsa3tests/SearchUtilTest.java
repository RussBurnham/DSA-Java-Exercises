package dsa3tests;

import dsa3.SearchUtil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchUtilTest {

    private int[] array = { 1, 2, 3 };
    private int[] emptyArray = {};

    @Test
    void testLinearSearch() {
        assertEquals(2, SearchUtil.linearSearch(array, 3));
        assertEquals(-1, SearchUtil.linearSearch(array, 4));
        assertEquals(-1, SearchUtil.linearSearch(emptyArray, 4));
    }

    @Test
    void testBinarySearch() {
        assertEquals(2, SearchUtil.binarySearch(array, 3));
        assertEquals(-1, SearchUtil.binarySearch(array, 4));
        assertEquals(-1, SearchUtil.binarySearch(emptyArray, 4));
    }

    @Test
    void testBinarySearchRecursive() {
        assertEquals(2, SearchUtil.binarySearchRecursive(array, 3));
        assertEquals(-1, SearchUtil.binarySearchRecursive(array, 4));
        assertEquals(-1, SearchUtil.binarySearchRecursive(emptyArray, 4));
    }

    @Test
    void testTernarySearch() {
        assertEquals(2, SearchUtil.ternarySearch(array, 3));
        assertEquals(-1, SearchUtil.ternarySearch(array, 4));
        assertEquals(-1, SearchUtil.ternarySearch(emptyArray, 4));
    }

    @Test
    void testJumpSearch() {
        assertEquals(2, SearchUtil.jumpSearch(array, 3));
        assertEquals(-1, SearchUtil.jumpSearch(array, 4));
        assertEquals(-1, SearchUtil.jumpSearch(emptyArray, 4));
    }

    @Test
    void testExponentialSearch() {
        assertEquals(2, SearchUtil.exponentialSearch(array, 3));
        assertEquals(-1, SearchUtil.exponentialSearch(array, 4));
        assertEquals(-1, SearchUtil.exponentialSearch(emptyArray, 4));
    }
}
