package stackandqueues.stackusingrecursion;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements to the stack
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        StackSorter sorter = new StackSorter();

        System.out.println("Original stack:");
        sorter.printStack((Stack<Integer>) stack.clone());

        // Sort the stack
        sorter.sortStack(stack);

        System.out.println("Sorted stack:");
        sorter.printStack(stack);
    }

}
