package circularlinkedlist.onlineticketreservation;

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add tickets
        system.addTicket(101, "Ishan", "Avatar 2", 15, "10:00 AM");
        system.addTicket(102, "Naman", "Interstellar", 23, "11:30 AM");
        system.addTicket(103, "Om", "Avatar 2", 7, "12:00 PM");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Avatar 2");
        system.searchTicket("David");

        // Remove a ticket
        system.removeTicket(102);
        system.displayTickets();

        // Display total tickets
        system.totalTickets();
    }
}
