package dsa1;

import java.util.Arrays;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void enqueue(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("\nLinkedListQueue empty.");
            return;
        }

        if (first == last) { 
            first = last = null;
        } else {
            first = first.next;
        }
        
        size--;
    }
    

    public boolean isEmpty() {
        return first == null;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("\nLinkedListQueue empty.");
            return null;
        }
            
        return first.value;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var index = 0;
        var current = first;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        
        return array;
    }

    @Override
    public String toString() {
        return "\nLinkedListQueue: " + Arrays.toString(toArray());
    }
}
