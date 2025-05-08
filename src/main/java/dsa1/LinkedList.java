package dsa1;

// import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public Integer indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("\nLinkedList is empty.");
            return;
        }
        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("\nLinkedList is empty.");
            return;
        }

        if (first == last) {
            first = last = null;
            return;
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
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

    public void reverse() {
        if (isEmpty()) {
            System.out.println("\nLinkedList is empty.");
            return;
        }

        Node previousNode = null;
        var currentNode = first; // A
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next; // A's next is B -> B's next is C -> C's next is D
            currentNode.next = previousNode; // assign A's next to Null -> assign B's next to A -> assign C's next to B
                                             // -> assign D's next to C
            previousNode = currentNode; // Null goes to A -> A goes to B -> B goes to C -> C goes to D
            currentNode = nextNode; // B -> C -> D
        }

        last = first;
        first = previousNode;
    }

    public Integer getKthFromTheEnd(int k) {
        if (isEmpty()) {
            System.out.println("\nLinkedList is empty.");
            return null;
        }

        Node pointer1 = first;
        Node pointer2 = first;

        for (int i = 0; i < k; i++) {
            if (pointer2 == null) {
                System.out.println("\nDistance out of bounds.");
                return null;
            }
            pointer2 = pointer2.next;
        }

        while (pointer2 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1.value;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return (first == null);
    }

}
