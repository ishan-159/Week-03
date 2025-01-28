package doublylinkedlist.librarymanagementsystem;

public class Main {

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Adding books
        library.addAtEnd("Book1", "Author1", "Fiction", 101, true);
        library.addAtBeginning("Book2", "Author2", "Non-Fiction", 102, false);
        library.addAtPosition(2, "Book3", "Author3", "Science", 103, true);

        // Display books forward
        library.displayBooksForward();
        System.out.println();

        // Search for a book
        library.searchBook("Book3", null);
        System.out.println();

        // Update availability status
        library.updateAvailabilityStatus(103, false);
        library.displayBooksForward();
        System.out.println();

        // Count books
        System.out.println("Total number of books: " + library.countBooks());
        System.out.println();

        // Display books in reverse order
        library.displayBooksReverse();
        System.out.println();

        // Remove a book
        library.removeByBookID(102);
        library.displayBooksForward();
    }
}
