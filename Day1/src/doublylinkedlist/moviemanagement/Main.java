package doublylinkedlist.moviemanagement;

// Main method for testing
public class Main{
public static void main(String[] args) {
    MovieManagementSystem system = new MovieManagementSystem();

    system.addAtEnd("Pushpa", "Sukumar", 2024, 9.0);
    system.addAtEnd("3-idiots", "Rajkumar Hirani", 2009, 9.5);
    system.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);

    system.displayMoviesForward();
    System.out.println();

    system.updateRatingByTitle("Inception", 9.3);
    system.searchMovie(null, 9.3);

    System.out.println("Movies in Reverse Order:");
    system.displayMoviesReverse();

    System.out.println("Removing 'Interstellar':");
    system.removeByTitle("Interstellar");
    system.displayMoviesForward();
}
}

