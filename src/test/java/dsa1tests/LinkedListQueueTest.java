package dsa1tests;

import dsa1.LinkedListQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LinkedListQueueTest {

    private LinkedListQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new LinkedListQueue();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertArrayEquals(new int[] { 10, 20 }, queue.toArray());
    }

    @Test
    public void testPeek() {
        assertNull(queue.peek()); 
        queue.enqueue(30);
        assertEquals(30, queue.peek());
        queue.enqueue(40);
        assertEquals(30, queue.peek()); 
    }

    @Test
    public void testDequeue() {
        queue.enqueue(100);
        queue.enqueue(200);
        queue.dequeue();

        assertEquals(1, queue.size());
        assertEquals(200, queue.peek());
        assertArrayEquals(new int[] { 200 }, queue.toArray());
    }

    @Test
    public void testDequeueToEmpty() {
        queue.enqueue(1);
        queue.dequeue(); 
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertNull(queue.peek());
    }

    @Test
    public void testDequeueOnEmpty() {
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            queue.dequeue();

            String output = outputStream.toString().trim();
            assertEquals("LinkedListQueue empty.", output);

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testToString() {
        queue.enqueue(7);
        queue.enqueue(8);
        assertEquals("[7, 8]", queue.toString());
    }
}
