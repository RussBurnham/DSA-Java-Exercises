package dsa1tests;

import dsa1.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackTest {

    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushSingleItem() {
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(42, stack.peek());
    }

    @Test
    public void testPushMultipleItems() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.peek());
        assertEquals("Stack: [10, 20, 30]", stack.toString());
    }

    @Test
    public void testPopSingleItem() {
        stack.push(99);
        assertEquals(99, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopMultipleItemsLIFO() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekDoesNotRemoveItem() {
        stack.push(7);
        assertEquals(7, stack.peek());
        assertEquals(7, stack.peek());
    }

    @Test
    public void testPopOnEmptyStack() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            assertNull(stack.pop());
            assertEquals("Stack empty.", out.toString().trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testPeekOnEmptyStack() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            assertNull(stack.peek());
            assertEquals("Stack empty.", out.toString().trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testToStringReflectsStackState() {
        stack.push(5);
        stack.push(15);
        assertEquals("Stack: [5, 15]", stack.toString());

        stack.pop();
        assertEquals("Stack: [5]", stack.toString());
    }
}
