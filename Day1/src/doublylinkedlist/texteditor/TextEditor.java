package doublylinkedlist.texteditor;


class TextEditor {
    private TextState head;  // Head of the doubly linked list
    private TextState tail;  // Tail of the doubly linked list
    private TextState currentState;  // Pointer to the current state
    private final int maxHistorySize;  // Limit for undo/redo history
    private int historySize = 0;

    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
    }

    // Add a new state to the history
    public void addState(String newContent) {
        TextState newState = new TextState(newContent);

        // If this is the first state
        if (head == null) {
            head = tail = currentState = newState;
        } else {
            // Remove forward redo history if any
            currentState.next = null;
            newState.prev = currentState;
            currentState.next = newState;
            currentState = newState;
            tail = newState;
        }

        // Increase history size and maintain the limit
        historySize++;
        if (historySize > maxHistorySize) {
            head = head.next;
            head.prev = null;
            historySize--;
        }
    }

    // Undo functionality
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo performed. Current state: " + currentState.content);
        } else {
            System.out.println("No more states to undo.");
        }
    }

    // Redo functionality
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo performed. Current state: " + currentState.content);
        } else {
            System.out.println("No more states to redo.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current state: " + currentState.content);
        } else {
            System.out.println("No states available.");
        }
    }

    // Display all states for debugging
    public void displayAllStates() {
        System.out.println("All states in the editor:");
        TextState temp = head;
        while (temp != null) {
            System.out.println(temp.content + (temp == currentState ? " <- Current" : ""));
            temp = temp.next;
        }
    }
}

