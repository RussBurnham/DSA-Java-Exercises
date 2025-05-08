package dsa1tests;

import dsa1.PriorityQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    private PriorityQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new PriorityQueue();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testAddSingleItem() {
        queue.add(30);
        assertFalse(queue.isEmpty());
        assertEquals("[30, 0, 0, 0, 0]", queue.toString());
    }

    @Test
    public void testAddMultipleItemsInPriorityOrder() {
        queue.add(30);
        queue.add(20);
        queue.add(40);
        queue.add(10);
        queue.add(50); 

        assertTrue(queue.isFull());
        assertEquals("[10, 20, 30, 40, 50]", queue.toString());
    }

    @Test
    public void testAddWhenFull() {
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            queue.add(60);
            String output = outContent.toString().trim();
            assertEquals("PriorityQueue full.", output);
        } finally {
            System.setOut(originalOut);
        }

        assertEquals("[10, 20, 30, 40, 50]", queue.toString());
    }

    @Test
    public void testRemoveItem() {
        queue.add(20);
        queue.add(10);
        queue.add(30);

        Integer removed = queue.remove();
        assertEquals(30, removed);
        assertEquals("[10, 20, 0, 0, 0]", queue.toString());
        assertFalse(queue.isFull());
    }

    @Test
    public void testRemoveUntilEmpty() {
        queue.add(10);
        queue.remove();

        assertTrue(queue.isEmpty());
        assertEquals("[0, 0, 0, 0, 0]", queue.toString());
    }

    @Test
    public void testRemoveOnEmpty() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            Integer removed = queue.remove();
            assertNull(removed);
            String output = outContent.toString().trim();
            assertEquals("PriorityQueue empty.", output);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testToStringOutput() {
        queue.add(15);
        queue.add(5);
        assertEquals("[5, 15, 0, 0, 0]", queue.toString());
    }
}
