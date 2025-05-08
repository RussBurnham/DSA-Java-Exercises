package dsa1;

import java.util.Stack;

public class QueueByStacks {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2; 

    public QueueByStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item) {
        stack1.push(item);
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("\nQueueByStacks empty.");
            return null;
        }

        transferStack();

        return stack2.pop();
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("\nQueueByStacks empty.");
            return null;
        }

        transferStack();

        return stack2.peek();
    }

    private void transferStack() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        Stack<Integer> temp = new Stack<>();
        temp.addAll(stack1); // stack2 (oldest elements on top)

        Stack<Integer> reverseStack2 = new Stack<>();
        for (int i = stack2.size() - 1; i >= 0; i--) {
            reverseStack2.push(stack2.get(i)); // Reverse stack1 order
        }

        reverseStack2.addAll(temp); // Combine for correct queue order
        return "\nQueueByStacks: " + reverseStack2.toString();
    }
}




