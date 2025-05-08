package dsa1;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value; 
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null) {
            System.out.println("\nKey does not exist in this HashTable.");
            return;
        }

        getBucket(key).remove(entry);
    }

    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? "\nKey does not exist in this HashTable." : entry.value;
    }

    private LinkedList<Entry> getBucket(int key) {
        return table[key % capacity];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = key % capacity;
        if (table[index] == null)
            table[index] = new LinkedList<>();

        return table[index];
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            sb.append("Bucket(").append(i).append("): ");
            LinkedList<Entry> bucket = table[i];
            if (bucket == null || bucket.isEmpty()) {
                sb.append("[]");
            } else {
                for (Entry entry : bucket) {
                    sb.append("[ ").append(entry.key).append(": ").append(entry.value).append(" ], ");
                }
            }
            sb.append("\n");
        }
        return "\nHashTable: \n" + sb.toString();
    }
}
