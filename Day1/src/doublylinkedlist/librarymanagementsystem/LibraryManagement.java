package doublylinkedlist.librarymanagementsystem;

public class LibraryManagement {
    private Book head = null;
    private Book tail = null;

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            newBook.prev = tail;
            tail.next = newBook;
            tail = newBook;
        }
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookID, boolean isAvailable) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (position == 1) {
            addAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        Book temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds! Adding at the end.");
            addAtEnd(title, author, genre, bookID, isAvailable);
        } else {
            newBook.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newBook;
            } else {
                tail = newBook;
            }
            newBook.prev = temp;
            temp.next = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeByBookID(int bookID) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookID + " not found.");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Book with ID " + bookID + " removed.");
    }

    // Search for a book by Book Title or Author
    public void searchBook(String title, String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title) || temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: Title: " + temp.title + ", Author: " + temp.author +
                        ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookID, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability status updated for Book ID " + bookID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("Books in the library (Forward):");
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", ID: " + temp.bookID + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("Books in the library (Reverse):");
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", ID: " + temp.bookID + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}
