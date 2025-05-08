package dsa1tests;

import dsa1.Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {
    
    private Array<Integer> intArray;

    @BeforeEach
    void setup() {
        intArray = new Array<>(3);
    }

    @Test
    void testInsert() {
        intArray.insert(1);
        intArray.insert(2);
        intArray.insert(3);
        assertTrue(intArray.contains(1));
        assertTrue(intArray.contains(3));
        assertEquals(0, intArray.indexOf(1));
        assertEquals(2, intArray.indexOf(3));
    }
    
    @Test
    void testInsertAt() {
        intArray.insert(1);
        intArray.insert(2);
        intArray.insertAt(3, 1);
        assertEquals(1, intArray.indexOf(3));
        assertEquals(2, intArray.indexOf(2));
    }

    @Test
    void testRemoveAt() {
        intArray.insert(1);
        intArray.insert(2);
        intArray.insert(3);
        intArray.removeAt(1);
        assertFalse(intArray.contains(2));
        assertEquals(1, intArray.indexOf(3));
    }

    @Test
    void testIndexOf() {
        intArray.insert(1);
        intArray.insert(2);
        intArray.insert(3);
        assertEquals(2, intArray.indexOf(3));
        assertEquals(-1, intArray.indexOf(4));
    }

    @Test
    void testContains() {
        intArray.insert(1);
        assertTrue(intArray.contains(1));
        assertFalse(intArray.contains(2));
    }

    @Test
    void testResize() {
        intArray.insert(1);
        intArray.insert(2);
        intArray.insert(3);
        intArray.insert(4); // Triggers resize
        assertTrue(intArray.contains(4));
        assertEquals(3, intArray.indexOf(4));
    }
}
