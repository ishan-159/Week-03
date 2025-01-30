package stackandqueues.circulartour;

public class Main {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        CircularTour tour = new CircularTour();

        int startingPump = tour.findStartingPump(petrol, distance);

        if (startingPump == -1) {
            System.out.println("No tour is possible.");
        } else {
            System.out.println("The starting pump is: " + startingPump);
        }
    }
}