package circularlinkedlist.taskscheduler;

public class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    // Add a task at the beginning
    public void addAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Maintain circular property
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain circular property
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, int taskID, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (position == 1) {
            addAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        for (int i = 1; i < position - 1 && temp != tail; i++) {
            temp = temp.next;
        }
        if (temp == tail) {
            System.out.println("Position out of bounds! Adding at the end.");
            addAtEnd(taskID, taskName, priority, dueDate);
        } else {
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeByTaskID(int taskID) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }
        Task temp = head, prev = null;
        do {
            if (temp.taskID == taskID) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head; // Maintain circular property
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + taskID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task with ID " + taskID + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTaskAndMoveNext() {
        if (currentTask == null) {
            currentTask = head; // Start from head if not already started
        }
        if (currentTask == null) {
            System.out.println("The task list is empty.");
        } else {
            System.out.println("Current Task: ID: " + currentTask.taskID + ", Name: " + currentTask.taskName +
                    ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
            currentTask = currentTask.next;
        }
    }

    // Display all tasks in the list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }
        Task temp = head;
        System.out.println("Task List:");
        do {
            System.out.println("ID: " + temp.taskID + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found: ID: " + temp.taskID + ", Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }

}

