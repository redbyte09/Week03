package com.linkedlist.movie;

public class MovieManagementSystem {

    private Movie head;
    private Movie tail;

    // Movie class to store movie details
    private static class Movie {
        String title;
        String director;
        int yearOfRelease;
        double rating;
        Movie next;
        Movie prev;

        public Movie(String title, String director, int yearOfRelease, double rating) {
            this.title = title;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
        }
    }

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        newMovie.next = head;
        if (head != null) {
            head.prev = newMovie;
        }
        head = newMovie;
        if (tail == null) {
            tail = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail != null) {
            tail.next = newMovie;
            newMovie.prev = tail;
        }
        tail = newMovie;
        if (head == null) {
            head = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position <= 0) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        Movie current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            addAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.next = current.next;
            if (current.next != null) {
                current.next.prev = newMovie;
            }
            current.next = newMovie;
            newMovie.prev = current;
        }
    }

    // Delete a movie by Title
    public void deleteByTitle(String title) {
        if (head == null) return;

        // If head needs to be removed
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (head == null) {
                tail = null;
            }
            return;
        }

        Movie current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }

        if (current != null) {
            // Movie found, delete it
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current == tail) {
                tail = current.prev;
            }
        } else {
            System.out.println("Movie with title " + title + " not found.");
        }
    }

    // Search for a movie by Director or Rating
    public void searchByDirectorOrRating(String director, double rating) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director) || current.rating == rating) {
                System.out.println("Movie found: " + current.title + " directed by " + current.director + ", Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    // Update a movie's rating by Title
    public void updateRatingByTitle(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Updated Rating for " + title + " to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found!");
    }

    // Display all movie records in forward order
    public void displayAllForward() {
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title);
            System.out.println("Director: " + current.director);
            System.out.println("Year of Release: " + current.yearOfRelease);
            System.out.println("Rating: " + current.rating);
            System.out.println();
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayAllReverse() {
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title);
            System.out.println("Director: " + current.director);
            System.out.println("Year of Release: " + current.yearOfRelease);
            System.out.println("Rating: " + current.rating);
            System.out.println();
            current = current.prev;
        }
    }

    // Main method to test the system
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        // Add some movies
        mms.addAtEnd("Kal Ho Na Ho", "Raja", 2010, 8.8);
        mms.addAtEnd("KGF", "Yash", 2008, 9.0);
        mms.addAtEnd("Main Hoon Na", "Kapil", 2014, 8.6);

        System.out.println("Initial Movie Records:");
        mms.displayAllForward();

        // Add a movie at the beginning
        mms.addAtBeginning("The Life", "Mohit", 2006, 8.5);

        // Add a movie at position 2
        mms.addAtPosition(2, "Main Thi", "Gola", 2017, 7.9);

        // Display movies after additions
        System.out.println("\nAfter Additions:");
        mms.displayAllForward();

        // Search movies by director
        System.out.println("\nSearch by Director 'Gola':");
        mms.searchByDirectorOrRating("Gola", 0);

        // Update rating for a movie
        mms.updateRatingByTitle("Main Thi", 8.7);

        // Display movies after update
        System.out.println("\nAfter Rating Update:");
        mms.displayAllForward();

        // Delete a movie by title
        mms.deleteByTitle("Interstellar"); // This will print a message indicating the movie isn't found

        // Display movies after deletion
        System.out.println("\nAfter Deletion (Interstellar):");
        mms.displayAllForward();

        // Display movies in reverse order
        System.out.println("\nMovies in Reverse Order:");
        mms.displayAllReverse();
    }
}
