package circularlinkedlist.roundrobinschedulingalgorithm;

class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

