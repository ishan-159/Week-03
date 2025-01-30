package stackandqueues.stackusingrecursion;

import java.util.Stack;

class StackSorter {

    //Method to sort the stack
    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int topElement = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back into the sorted stack
        insertSorted(stack, topElement);
    }

    //Method to insert an element into the sorted stack
    private void insertSorted(Stack<Integer> stack, int element) {
        // If the stack is empty or the element is greater than the top, push the element
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            // Otherwise, pop the top and recursively call insertSorted to find the right position
            int temp = stack.pop();
            insertSorted(stack, element);
            // Push the popped element back after inserting the element
            stack.push(temp);
        }
    }

    //Method to print the stack (for testing purposes)
    public void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

