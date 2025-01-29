package com.linkedlist.studentrecord;

//create a class here
public class StudentManagementSystem {
  //set the private fields head and tail
    private Student head;
    private Student tail;

    // Add a new student at the beginning
    public void addAtBeginning(String name, int age, int rollNumber, char grade) {
        Student newStudent = new Student(name, age, rollNumber, grade);
        newStudent.next = head;
        head = newStudent;
        if (tail == null) {
            tail = newStudent;
        }
    }

    // Add a new student at the end
    public void addAtEnd(String name, int age, int rollNumber, char grade) {
        Student newStudent = new Student(name, age, rollNumber, grade);
        if (tail != null) {
            tail.next = newStudent;
        }
        tail = newStudent;
        if (head == null) {
            head = newStudent;
        }
    }

    // Add a new student at a specific position
    public void addAtPosition(int position, String name, int age, int rollNumber, char grade) {
        if (position <= 0) {
            addAtBeginning(name, age, rollNumber, grade);
            return;
        }

        Student newStudent = new Student(name, age, rollNumber, grade);
        Student current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            addAtEnd(name, age, rollNumber, grade);
        } else {
            newStudent.next = current.next;
            current.next = newStudent;
        }
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;

        if (head.rollNumber == rollNumber) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
    }

    // Search for a student record by Roll Number
    public Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update a student's grade by Roll Number
    public void updateGradeByRollNumber(int rollNumber, char newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    // Display all student records
    public void displayAll() {
        Student current = head;
        while (current != null) {
            System.out.println("Name: " + current.name);
            System.out.println("Age: " + current.age);
            System.out.println("Roll Number: " + current.rollNumber);
            System.out.println("Grade: " + current.grade);
            System.out.println();

            current = current.next;
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        // Add initial students
        sms.addAtEnd("Adarsh", 22, 101, 'E');
        sms.addAtEnd("Unaiz", 23, 102, 'B');
        sms.addAtEnd("Harsh", 24, 103, 'C');

        // Display all records
        System.out.println("Initial Records:");
        sms.displayAll();

        // Add a student at the beginning
        sms.addAtBeginning("Pranjal", 25, 104, 'A');

        // Add a student at the end
        sms.addAtEnd("Mikhani", 26, 105, 'D');

        // Add a student at position 2
        sms.addAtPosition(2, "Mohini", 27, 106, 'E');

        // Display all records after additions
        System.out.println("\nRecords After Additions:");
        sms.displayAll();

        // Delete a student by Roll Number
        sms.deleteByRollNumber(103);

        // Display all records after deletion
        System.out.println("\nRecords After Deletion (Roll Number 103):");
        sms.displayAll();

        // Update a student's grade
        sms.updateGradeByRollNumber(104, 'B');

        // Display all records after update
        System.out.println("\nRecords After Grade Update (Roll Number 104):");
        sms.displayAll();
    }
}
