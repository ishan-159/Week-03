package doublylinkedlist.moviemanagement;


public class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
        } else {
            newMovie.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            } else {
                tail = newMovie; // Update tail if inserted at the end
            }
            temp.next = newMovie;
            newMovie.prev = temp;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie with title \"" + title + "\" not found.");
        } else {
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
            System.out.println("Movie with title \"" + title + "\" removed.");
        }
    }

    // Search for a movie by Director or Rating
    public void searchMovie(String director, Double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if ((director != null && temp.director.equalsIgnoreCase(director)) ||
                    (rating != null && temp.rating == rating)) {
                System.out.println("Movie Found: Title: " + temp.title + ", Director: " + temp.director +
                        ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with the given criteria.");
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = head;
        System.out.println("Movies in Forward Order:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = tail;
        System.out.println("Movies in Reverse Order:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRatingByTitle(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for movie \"" + title + "\".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }
}

