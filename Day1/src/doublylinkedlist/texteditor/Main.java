package doublylinkedlist.texteditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Limit to the last 10 states

        // Simulate user actions
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! How are you?");
        editor.displayCurrentState();

        // Perform Undo and Redo operations
        editor.undo();
        editor.undo();
        editor.redo();
        editor.displayCurrentState();

        // Display all states
        editor.displayAllStates();

        // Add more states and test the history limit
        editor.addState("New content after undo.");
        editor.addState("Another update.");
        editor.displayAllStates();
    }
}
