package dsa2tests;

import dsa2.MinHeap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MinHeapTest {
    private MinHeap minHeap;

    @BeforeEach
    public void setUp() {
        minHeap = new MinHeap(5);
    }

    @Test
    public void testInsertSingleElement() {
        minHeap.insert(10, "A");
        assertFalse(minHeap.isEmpty());
    }

    @Test
    public void testRemoveReturnsMinValue() {
        minHeap.insert(20, "C");
        minHeap.insert(5, "A");
        minHeap.insert(15, "B");
        assertEquals("A", minHeap.remove());
    }

    @Test
    public void testHeapOrdersByMinKey() {
        minHeap.insert(30, "D");
        minHeap.insert(10, "B");
        minHeap.insert(20, "C");
        minHeap.insert(5, "A");

        assertEquals("A", minHeap.remove());
        assertEquals("B", minHeap.remove());
        assertEquals("C", minHeap.remove());
        assertEquals("D", minHeap.remove());
    }

    @Test
    public void testIsFull() {
        minHeap.insert(1, "A");
        minHeap.insert(2, "B");
        minHeap.insert(3, "C");
        minHeap.insert(4, "D");
        minHeap.insert(5, "E");
        assertTrue(minHeap.isFull());
    }

    @Test
    public void testRemoveFromEmptyHeap() {
        assertEquals("MinHeap empty.", minHeap.remove());
    }

    @Test
    public void testInsertIntoFullHeap() {
        minHeap.insert(1, "A");
        minHeap.insert(2, "B");
        minHeap.insert(3, "C");
        minHeap.insert(4, "D");
        minHeap.insert(5, "E");

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            minHeap.insert(0, "F");

            String output = outputStream.toString().trim();
            assertEquals("MinHeap full.", output);

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testMultipleInsertAndRemove() {
        minHeap.insert(50, "X");
        minHeap.insert(40, "Y");
        minHeap.insert(60, "Z");

        assertEquals("Y", minHeap.remove());
        minHeap.insert(10, "W");
        assertEquals("W", minHeap.remove());
    }
}
