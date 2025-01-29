package com.linkedlist.TaskScheduler;

public class TaskScheduler {
    private Task head = null;  // Head of the circular linked list
    private Task tail = null;  // Tail of the circular linked list
    private Task current = null; // To keep track of the current task for navigation

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head; // Circular reference
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Maintain circular structure
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head; // Circular reference
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain circular structure
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task current = head;
        int count = 0;

        while (count < position - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == head) {
            addAtEnd(taskId, taskName, priority, dueDate);
        } else {
            newTask.next = current.next;
            current.next = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks available to remove.");
            return;
        }

        Task current = head;
        Task previous = null;

        do {
            if (current.taskId == taskId) {
                if (previous == null) {
                    head = head.next;
                    tail.next = head;  // Maintain circular structure
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;  // Update tail if the last task is removed
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View current task and move to the next task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task:");
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task Found: ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addAtEnd(1, "Task 1", 2, "2025-02-01");
        scheduler.addAtEnd(2, "Task 2", 1, "2025-01-15");
        scheduler.addAtBeginning(3, "Task 3", 3, "2025-03-05");
        scheduler.addAtPosition(2, 4, "Task 4", 2, "2025-02-10");

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View current task and move to the next
        System.out.println("\nView current task:");
        scheduler.viewCurrentTask(); // Displays the first task
        scheduler.viewCurrentTask(); // Moves to next task

        // Search for tasks by priority
        System.out.println("\nSearch tasks with Priority 2:");
        scheduler.searchByPriority(2);

        // Remove task by Task ID
        System.out.println("\nRemove Task with ID 2:");
        scheduler.removeByTaskId(2);

        // Display all tasks after removal
        System.out.println("\nAll Tasks after removal:");
        scheduler.displayAllTasks();
    }
}

