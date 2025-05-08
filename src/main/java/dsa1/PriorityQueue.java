package dsa1;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if (isFull()) {
            System.out.println("\nPriorityQueue full.");
            return;
        }

        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    public Integer remove() {
        if (isEmpty()) {
            System.out.println("\nPriorityQueue empty.");
            return null;
        }

        Integer item = items[--count];
        items[count] = 0;

        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "\nPriorityQueue: " + Arrays.toString(items);
    }
}

