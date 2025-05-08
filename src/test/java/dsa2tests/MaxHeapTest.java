package dsa2tests;

import dsa2.MaxHeap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MaxHeapTest {
    private MaxHeap maxHeap;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap(10);
    }

    @Test
    void testInsert() {
        maxHeap.insert(15);
        assertEquals(15, maxHeap.max());

        maxHeap.insert(10);
        assertEquals(15, maxHeap.max());
    }

    @Test
    void testRemove() {
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(20);

        assertEquals(20, maxHeap.remove());
        assertEquals(15, maxHeap.max());
    }

    @Test
    void testIsEmpty() {
        assertTrue(maxHeap.isEmpty());

        maxHeap.insert(15);
        assertFalse(maxHeap.isEmpty());
    }

    @Test
    void testIsFull() {
        var miniMaxHeap = new MaxHeap(2);
        assertFalse(miniMaxHeap.isFull());

        miniMaxHeap.insert(10);
        miniMaxHeap.insert(20);
        assertTrue(miniMaxHeap.isFull());
    }

    @Test
    void testMax() {
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(10);

        assertEquals(30, maxHeap.max());
    }

    @Test
    void testRemoveFromEmptyHeap() {
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            maxHeap.remove();

            String output = outputStream.toString().trim();
            assertEquals("MaxHeap empty.", output);

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testInsertIntoFullHeap() {
        var miniMaxHeap = new MaxHeap(2);
        miniMaxHeap.insert(10);
        miniMaxHeap.insert(20);

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            miniMaxHeap.insert(30);

            String output = outputStream.toString().trim();
            assertEquals("MaxHeap full.", output);

        } finally {
            System.setOut(originalOut);
        }

        assertEquals(20, miniMaxHeap.remove());
    }

    @Test
    void testHeapProperty() {
        maxHeap.insert(10);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(25);
        maxHeap.insert(30);

        assertEquals(30, maxHeap.max());
    }
}
