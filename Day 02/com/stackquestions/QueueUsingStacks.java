package com.stackquestions;
import java.util.Stack;
public class QueueUsingStacks {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Enqueue operation: Push element onto stack1
        public void enqueue(int data) {
            stack1.push(data);
        }

        // Dequeue operation: If stack2 is empty, move elements from stack1 to stack2, then pop
        public int dequeue() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    System.out.println("Queue is empty");
                    return -1; // Indicating an empty queue
                }
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public static void main(String[] args) {
            QueueUsingStacks queue = new QueueUsingStacks();

            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            System.out.println(queue.dequeue()); // Output: 1
            System.out.println(queue.dequeue()); // Output: 2

            queue.enqueue(4);

            System.out.println(queue.dequeue()); // Output: 3
            System.out.println(queue.dequeue()); // Output: 4
            System.out.println(queue.dequeue()); // Output: Queue is empty, -1
        }
    }


