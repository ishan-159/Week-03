package circularlinkedlist.roundrobinschedulingalgorithm;

class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;

    // Add a process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            tail.next = head; // Make it circular
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular connection
        }
        System.out.println("Process " + processID + " added to the queue.");
    }

    // Remove a process by Process ID
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;

        do {
            if (current.processID == processID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Process " + processID + " removed from the queue.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process " + processID + " not found.");
    }

    // Simulate Round Robin Scheduling
    public void roundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        int totalProcesses = countProcesses();
        int[] waitingTimes = new int[totalProcesses];
        int[] turnAroundTimes = new int[totalProcesses];
        int currentTime = 0;

        ProcessNode current = head;
        do {
            if (current.burstTime > 0) {
                int executionTime = Math.min(current.burstTime, timeQuantum);
                current.burstTime -= executionTime;
                currentTime += executionTime;

                // If the process is finished, calculate times
                if (current.burstTime == 0) {
                    int processIndex = current.processID - 1; // Assuming process IDs start from 1
                    turnAroundTimes[processIndex] = currentTime;
                    waitingTimes[processIndex] = turnAroundTimes[processIndex] - executionTime;
                }

                System.out.println("Executing Process " + current.processID + ", Remaining Burst Time: " + current.burstTime);
            }
            current = current.next;
        } while (anyProcessRemaining());

        // Calculate and display average waiting and turnaround times
        double avgWaitingTime = 0, avgTurnAroundTime = 0;
        for (int i = 0; i < totalProcesses; i++) {
            avgWaitingTime += waitingTimes[i];
            avgTurnAroundTime += turnAroundTimes[i];
        }

        avgWaitingTime /= totalProcesses;
        avgTurnAroundTime /= totalProcesses;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turn-Around Time: " + avgTurnAroundTime);
    }

    // Check if any process has burst time remaining
    private boolean anyProcessRemaining() {
        ProcessNode current = head;
        do {
            if (current.burstTime > 0) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    // Count the number of processes in the list
    private int countProcesses() {
        if (head == null) return 0;

        int count = 0;
        ProcessNode current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    // Display the process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode current = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + current.processID + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }


}

