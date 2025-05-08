package dsa1;

import java.util.Arrays;

public class Stack {
    private int[] array;
    private int size;

    public Stack() {
        array = new int[0];
        size = 0;
    }

    public void push(int num) {
        size++;
        array = Arrays.copyOf(array, size);
        array[size - 1] = num;
    }

    public Integer pop() {
        if (size == 0) {
            System.out.println("\nStack empty.");
            return null;
        }
        
        int poppedNum = array[size - 1];

        size--;
        array = Arrays.copyOf(array, size);

        return poppedNum;
    }


    public Integer peek() {
        if (size == 0) {
            System.out.println("\nStack empty.");
            return null;
        }

        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.toString(Arrays.copyOf(array, size));
        return "\nStack: " + content;
    }
}
