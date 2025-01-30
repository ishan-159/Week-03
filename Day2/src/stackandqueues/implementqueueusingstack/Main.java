package stackandqueues.implementqueueusingstack;

public class Main {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements
        System.out.println("Dequeue: " + queue.dequeue());  // 10
        System.out.println("Dequeue: " + queue.dequeue());  // 20

        // Enqueue more elements
        queue.enqueue(40);

        // Dequeue remaining elements
        System.out.println("Dequeue: " + queue.dequeue());  // 30
        System.out.println("Dequeue: " + queue.dequeue());  // 40
    }
}
