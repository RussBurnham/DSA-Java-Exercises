package dsa1tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import dsa1.ArrayQueue;

public class ArrayQueueTest {
    
    private ArrayQueue queue;

    @BeforeEach
    void setup() {
        queue = new ArrayQueue();
    }

    @Test
    void testArrayQueueInitialState() {
        assertTrue(queue.isEmpty() == true);
        assertTrue(queue.isFull() == false);
        assertEquals(null, queue.peek());
    }

    @Test
    void testEnqueueSingleItem() {
        queue.enqueue(5);
        assertTrue(queue.isEmpty() == false);
        assertEquals(5, queue.peek());
        assertTrue(queue.toString().equals("\nArrayQueue: [5]"));
    }

    @Test
    void testDequeueAfterEnqueueSingleItem() {
        queue.enqueue(5);
        queue.dequeue();
        assertTrue(queue.isEmpty() == true);
        assertEquals(null, queue.peek());
    }

    @Test
    void testWrapAroundLogic() {
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals("\nArrayQueue: [1, 1, 2, 3, 4, 5]", queue.toString());
        queue.dequeue();
        queue.dequeue();
        assertEquals(2, queue.peek());
        assertEquals("\nArrayQueue: [2, 3, 4, 5]", queue.toString());
    }
}
