package stackandqueues.implementqueueusingstack;

import java.util.Stack;

class QueueUsingStacks {
    // Two stacks
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);  // Push element to stack1
    }

    // Dequeue operation
    public int dequeue() {
        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;  // Or throw an exception
        }

        // Pop element from stack2 (the front of the queue)
        return stack2.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
