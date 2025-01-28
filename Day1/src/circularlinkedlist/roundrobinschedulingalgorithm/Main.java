package circularlinkedlist.roundrobinschedulingalgorithm;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        // Display processes
        scheduler.displayProcesses();

        // Simulate Round Robin Scheduling
        System.out.println("Simulating Round Robin Scheduling with Time Quantum = 4");
        scheduler.roundRobin(4);

        // Display remaining processes
        scheduler.displayProcesses();
    }
}
