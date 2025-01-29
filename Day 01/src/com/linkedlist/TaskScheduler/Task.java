package com.linkedlist.TaskScheduler;

public class Task {
    // Node representing each task

        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;

        // Constructor to initialize task properties
        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

