package dsa1;

import java.util.Arrays;

public class ArrayQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        array = new int[5];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            int[] newArray = new int[array.length * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[(front + i) % array.length];
            }

            array = newArray;
            front = 0;
            rear = size; 
        }

        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("\nArrayQueue empty.");
            return;
        }

        front = (front + 1) % array.length;
        size--;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("\nArrayQueue empty.");
            return null;
        }
        return array[front];
    }

    public boolean isEmpty() {
        return size == 0; 
    }

    public boolean isFull() {
        return size == array.length; 
    }

    @Override
    public String toString() {
        int[] content = new int[size];

        for (int i = 0; i < size; i++) {
            content[i] = array[(front + i) % array.length];
        }

        return "\nArrayQueue: " + Arrays.toString(content);
    }
}
