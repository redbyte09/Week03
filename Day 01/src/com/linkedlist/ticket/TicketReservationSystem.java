package com.linkedlist.ticket;

public class TicketReservationSystem {

    private Ticket head = null;  // Head of the circular linked list
    private Ticket tail = null;  // Tail of the circular linked list
    private int ticketCount = 0; // Total number of booked tickets

    // Add a new ticket reservation at the end of the circular linked list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Circular link
        }
        ticketCount++;
        System.out.println("Ticket booked successfully for customer: " + customerName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicketById(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;

        // Traverse the circular linked list to find the ticket by ID
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {
                    head = tail = null; // List becomes empty
                } else if (current == head) {
                    head = head.next; // Remove the head node
                    tail.next = head; // Update tail's next pointer
                } else if (current == tail) {
                    previous.next = head; // Remove the tail node
                    tail = previous; // Update the tail pointer
                } else {
                    previous.next = current.next; // Remove the intermediate node
                }
                ticketCount--;
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Display all tickets in the circular linked list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name
    public void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket Found: ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for customer: " + customerName);
        }
    }

    // Search for a ticket by Movie Name
    public void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket Found: ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for movie: " + movieName);
        }
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        return ticketCount;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding ticket reservations
        system.addTicket(1, "John", "Avengers", "A1", "2025-01-28 15:00");
        system.addTicket(2, "Janny", "Jolly", "B2", "2025-01-28 16:00");
        system.addTicket(3, "Sam", "Avatar", "C3", "2025-01-28 17:00");

        // Display all tickets
        System.out.println("Current Booked Tickets:");
        system.displayTickets();

        // Search tickets by customer and movie
        System.out.println("\nSearch by Customer Name (John):");
        system.searchByCustomerName("John");

        System.out.println("\nSearch by Movie Name (Jolly):");
        system.searchByMovieName("Jolly");

        // Remove a ticket
        system.removeTicketById(2);

        // Display remaining tickets
        System.out.println("\nRemaining Booked Tickets:");
        system.displayTickets();

        // Display the total number of tickets
        System.out.println("\nTotal Booked Tickets: " + system.countTickets());
    }
}
