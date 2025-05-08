package dsa1tests;

import dsa1.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LinkedListTest {
    
    private LinkedList linkedList;

    @BeforeEach
    void setup() {
        linkedList = new LinkedList();
    }

    @Test
    void testAddFirst() {
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        assertEquals(0, linkedList.indexOf(2));
    }

    @Test
    void testAddLast() {
        linkedList.addFirst(1);
        linkedList.addLast(2);

        assertEquals(1, linkedList.indexOf(2));
    }

    @Test
    void testRemoveFirst() {
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.removeFirst();
        assertEquals(1, linkedList.toArray().length);
        assertEquals(2, linkedList.toArray()[0]);
    }

    @Test
    void testRemoveLast() {
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.removeLast();
        assertEquals(1, linkedList.toArray().length);
        assertEquals(1, linkedList.toArray()[0]);
    }

    @Test
    void testRemoveFirstEmptyLinkedList() {
         PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            linkedList.removeFirst();

            String output = outputStream.toString().trim();
            assertEquals("LinkedList is empty.", output);

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testRemoveLastEmptyLinkedList() {
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            linkedList.removeLast();

            String output = outputStream.toString().trim();
            assertEquals("LinkedList is empty.", output);

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testLinkedListToArray() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        assertEquals(3, linkedList.toArray().length);
        assertEquals(1, linkedList.toArray()[0]);
        assertEquals(2, linkedList.toArray()[1]);
        assertEquals(3, linkedList.toArray()[2]);
    }

    @Test
    void testReverse() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.reverse();
        assertEquals(0, linkedList.indexOf(3));
        assertEquals(2, linkedList.indexOf(1));
    }

    @Test
    void testGetKthFromTheEnd() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        assertEquals(1, linkedList.getKthFromTheEnd(3));
    } 
}
