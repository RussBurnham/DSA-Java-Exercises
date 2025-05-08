package dsa1tests;

import dsa1.QueueByStacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class QueueByStacksTest {

    private QueueByStacks queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueByStacks();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueSingleItem() {
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        assertEquals(10, queue.peek());
    }

    @Test
    public void testEnqueueMultipleItemsOrder() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(10, queue.peek());
        assertEquals("\nQueueByStacks: [10, 20, 30]", queue.toString());
    }

    @Test
    public void testDequeueSingleItem() {
        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueMultipleItemsMaintainsOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeekDoesNotRemove() {
        queue.enqueue(100);
        assertEquals(100, queue.peek());
        assertEquals(100, queue.peek()); 
    }

    @Test
    public void testDequeueOnEmpty() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            Integer result = queue.dequeue();
            assertNull(result);
            assertEquals("QueueByStacks empty.", out.toString().trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testPeekOnEmpty() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            Integer result = queue.peek();
            assertNull(result);
            assertEquals("QueueByStacks empty.", out.toString().trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testToStringReflectsQueueOrder() {
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        assertEquals("\nQueueByStacks: [5, 10, 15]", queue.toString());

        queue.dequeue();
        assertEquals("\nQueueByStacks: [10, 15]", queue.toString());

        queue.enqueue(20);
        assertEquals("\nQueueByStacks: [10, 15, 20]", queue.toString());
    }
}
