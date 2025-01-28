package circularlinkedlist.onlineticketreservation;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next; // Pointer to the next ticket in the circular list

    public Ticket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

