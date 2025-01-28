package circularlinkedlist.onlineticketreservation;

class TicketReservationSystem {
    private Ticket last; // Pointer to the last ticket in the circular list
    private int ticketCount = 0; // Total number of tickets

    // Add a new ticket at the end of the list
    public void addTicket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (last == null) {
            // First ticket, point to itself
            last = newTicket;
            last.next = last;
        } else {
            // Insert at the end and maintain circularity
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        ticketCount++;
        System.out.println("Ticket added successfully: " + ticketID);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = last.next;
        Ticket previous = last;

        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    // Only one ticket in the list
                    last = null;
                } else {
                    previous.next = current.next;
                    if (current == last) {
                        // If the ticket to remove is the last ticket
                        last = previous;
                    }
                }
                ticketCount--;
                System.out.println("Ticket removed successfully: " + ticketID);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket not found: " + ticketID);
    }

    // Display all tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets in the system.");
            return;
        }

        System.out.println("Current Tickets:");
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (last == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket current = last.next;
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found Ticket: Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for: " + keyword);
        }
    }

    // Calculate the total number of booked tickets
    public void totalTickets() {
        System.out.println("Total number of booked tickets: " + ticketCount);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add tickets
        system.addTicket(101, "Alice", "Avatar 2", 15, "10:00 AM");
        system.addTicket(102, "Bob", "Interstellar", 23, "11:30 AM");
        system.addTicket(103, "Charlie", "Avatar 2", 7, "12:00 PM");

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


