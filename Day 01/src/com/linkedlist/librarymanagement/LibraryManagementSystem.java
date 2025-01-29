package com.linkedlist.librarymanagement;

public class LibraryManagementSystem {

    private Book head = null;  // Head of the doubly linked list
    private Book tail = null;  // Tail of the doubly linked list
    private int bookCount = 0; // Total number of books in the library

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 0) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;
        int count = 0;

        while (count < position - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
            bookCount++;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("No books available to remove.");
            return;
        }

        Book current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                bookCount--;
                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Book Title
    public void searchByTitle(String title) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Book with title \"" + title + "\" not found.");
        }
    }

    // Search for a book by Author
    public void searchByAuthor(String author) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No books found by author \"" + author + "\".");
        }
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookId, boolean isAvailable) {
        Book current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Book with ID " + bookId + " availability updated.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        Book current = head;
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }

        Book current = tail;
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        return bookCount;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addAtEnd("The Life", "Maharaj", "Fiction", 1, true);
        library.addAtEnd("To Killing", "Kamla", "Fiction", 2, true);
        library.addAtBeginning("1984", "Genny", "Drama", 3, true);
        library.addAtPosition(2, "Horror", "Herman ", "Adventure", 4, false);

        System.out.println("All Books (Forward Order):");
        library.displayBooksForward();

        // Search for books by title and author
        System.out.println("\nSearch by Title (1984):");
        library.searchByTitle("1984");

        System.out.println("\nSearch by Author (Kamla):");
        library.searchByAuthor("Kamla");

        // Update availability status
        library.updateAvailabilityStatus(1, false);

        // Display books in reverse order
        System.out.println("\nAll Books (Reverse Order):");
        library.displayBooksReverse();

        // Remove a book
        library.removeByBookId(2);

        // Display total number of books
        System.out.println("\nTotal Books in the Library: " + library.countBooks());
    }
}

