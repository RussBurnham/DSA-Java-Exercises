package dsa1tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dsa1.HashTable;

public class HashTableTest {
    
    private HashTable hashTable;

    @BeforeEach
    public void setup() {
        hashTable = new HashTable(3); 
    }

    @Test
    public void testPutAndGetSingleEntry() {
        hashTable.put(1, "One");
        assertEquals("One", hashTable.get(1));
    }

    @Test
    public void testUpdateExistingKey() {
        hashTable.put(2, "Two");
        hashTable.put(2, "Second");
        assertEquals("Second", hashTable.get(2));
    }

    @Test
    public void testRemoveExistingKey() {
        hashTable.put(3, "Three");
        hashTable.remove(3);
        assertEquals("\nKey does not exist in this HashTable.", hashTable.get(3));
    }

    @Test
    public void testRemoveNonExistentKey() {
        hashTable.remove(99);
        assertEquals("\nKey does not exist in this HashTable.", hashTable.get(99));
    }

    @Test
    public void testMultipleEntriesWithSameHash() {
        hashTable.put(1, "One");
        hashTable.put(4, "Four");
        hashTable.put(7, "Seven");

        assertEquals("One", hashTable.get(1));
        assertEquals("Four", hashTable.get(4));
        assertEquals("Seven", hashTable.get(7));
    }
}
