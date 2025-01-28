package circularlinkedlist.taskscheduler;

public class Main {

    // Main method for testing
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addAtEnd(1, "Task 1", 5, "2025-02-01");
        scheduler.addAtEnd(2, "Task 2", 3, "2025-02-05");
        scheduler.addAtBeginning(3, "Task 3", 4, "2025-01-30");

        // Display all tasks
        scheduler.displayAllTasks();
        System.out.println();

        // View current task and move to the next
        scheduler.viewCurrentTaskAndMoveNext();
        scheduler.viewCurrentTaskAndMoveNext();
        scheduler.viewCurrentTaskAndMoveNext();

        System.out.println();

        // Search by priority
        scheduler.searchByPriority(4);

        System.out.println();

        // Remove a task
        scheduler.removeByTaskID(2);
        scheduler.displayAllTasks();
    }
}
