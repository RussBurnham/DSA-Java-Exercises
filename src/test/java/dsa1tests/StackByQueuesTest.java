package dsa1tests;

import dsa1.StackByQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackByQueuesTest {

    private StackByQueues stack;

    @BeforeEach
    public void setUp() {
        stack = new StackByQueues();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushSingleItem() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPushMultipleItems() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
        assertEquals("[1, 2, 3]", stack.toString());
    }

    @Test
    public void testPopRemovesTopItem() {
        stack.push(100);
        stack.push(200);
        stack.push(300);
        assertEquals(300, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(200, stack.peek());
    }

    @Test
    public void testPopMultipleItemsLIFO() {
        stack.push(5);
        stack.push(6);
        stack.push(7);
        assertEquals(7, stack.pop());
        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekDoesNotRemove() {
        stack.push(42);
        assertEquals(42, stack.peek());
        assertEquals(42, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testPopOnEmptyStack() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            assertNull(stack.pop());
            assertEquals("StackByQueues empty.", out.toString().trim());
        } finally {
            System.setOut(original);
        }
    }

    @Test
    public void testPeekOnEmptyStack() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            assertNull(stack.peek());
            assertEquals("StackByQueues empty.", out.toString().trim());
        } finally {
            System.setOut(original);
        }
    }

    @Test
    public void testToStringReflectsQueueOrder() {
        stack.push(8);
        stack.push(9);
        stack.push(10);
        assertEquals("[8, 9, 10]", stack.toString());

        stack.pop();
        assertEquals("[8, 9]", stack.toString());
    }
}
