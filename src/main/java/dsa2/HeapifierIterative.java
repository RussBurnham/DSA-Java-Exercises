package dsa2;

public class HeapifierIterative {

    public static int[] heapify(int[] array) {
        int lastParent = array.length / 2 - 1;
        for (int i = lastParent; i >= 0; i--) {
            bubbleDown(i, array, array.length);
        }

        return array;
    }

    private static void bubbleDown(int index, int[] array, int size) {
        while (index < size) {
            int largerChild = largerChildIndex(index, array, size);

            if (largerChild == index || array[index] >= array[largerChild])
                break;

            swap(index, largerChild, array);
            index = largerChild;
        }
    }

    private static int largerChildIndex(int index, int[] array, int size) {
        if (!hasLeftChild(index, size))
            return index;

        if (!hasRightChild(index, size))
            return leftChildIndex(index);

        return (array[leftChildIndex(index)] > array[rightChildIndex(index)] ? leftChildIndex(index)
                : rightChildIndex(index));
    }

    private static boolean hasLeftChild(int index, int size) {
        return leftChildIndex(index) < size;
    }

    private static boolean hasRightChild(int index, int size) {
        return rightChildIndex(index) < size;
    }

    private static int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private static int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private static void swap(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
