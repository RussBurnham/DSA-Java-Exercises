package dsa1;

public class Array<T> {
    private T[] items;
    private int count;

    public int getCount() {
        return this.count;
    }

    @SuppressWarnings("unchecked")
    public Array(int length) {
        items = (T[]) new Object[length];
    }

    public void insert(T item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public void insertAt(T item, int index) {
        if (index < 0 || index > count) {
            System.out.println("\nIndex out of bounds.");
            return;
        }

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            System.out.println("\nIndex out of bounds.");
            return;
        }

        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];

        items[count - 1] = null;
        count--;
    }

    public int indexOf(T item) {
        for (int i = 0; i < count; i++) {
            if (items[i].equals(item))
                return i;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public void print() {
        System.out.print("{");
        for (int i = 0; i < count; i++) {   
            if (i == count - 1)
                System.out.print(" " + items[i] + " ");
            else
                System.out.print(" " + items[i] + ", ");
        }
        System.out.print("}");
    }

    @SuppressWarnings("unchecked")
    private void resizeIfRequired() {
        if (items.length == count) {
            T[] newItems = (T[]) new Object[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }
}
