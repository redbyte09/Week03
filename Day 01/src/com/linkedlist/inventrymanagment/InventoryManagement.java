package com.linkedlist.inventrymanagment;



public class InventoryManagement {
    private Inventory head;
    private Inventory tail;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, double quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemId, quantity, price);
        newInventory.next = head;
        head = newInventory;
        if (tail == null) {
            tail = newInventory;
        }
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, double quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemId, quantity, price);
        if (head == null) {
            head = newInventory;
            tail = newInventory;
        } else {
            tail.next = newInventory;
            tail = newInventory;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, double quantity, double price) {
        if (position <= 0) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Inventory newInventory = new Inventory(itemName, itemId, quantity, price);
        Inventory current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            addAtEnd(itemName, itemId, quantity, price);
        } else {
            newInventory.next = current.next;
            current.next = newInventory;
        }
    }

    // Remove an item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Inventory current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
    }

    // Update quantity by Item ID
    public void updateQuantityByItemId(int itemId, double newQuantity) {
        Inventory current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
    }

    // Search for an item by Item ID
    public Inventory searchByItemId(int itemId) {
        Inventory current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for an item by Item Name
    public Inventory searchByItemName(String itemName) {
        Inventory current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        double totalValue = 0;
        Inventory current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Display all inventory items
    public void displayInventory() {
        Inventory current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName);
            System.out.println("Item ID: " + current.itemId);
            System.out.println("Quantity: " + current.quantity);
            System.out.println("Price: " + current.price);
            System.out.println("-----------------------------");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();

        // Add items
        inventoryManagement.addAtBeginning("Soap", 101, 2, 20.0);
        inventoryManagement.addAtEnd("Sugar", 102, 5, 50.0);
        inventoryManagement.addAtPosition(1, "Pen", 103, 10, 15.0);

        // Display all inventory items
        System.out.println("Inventory after adding items:");
        inventoryManagement.displayInventory();

        // Remove an item
        inventoryManagement.removeByItemId(102);
        System.out.println("Inventory after removing Item ID 102:");
        inventoryManagement.displayInventory();

        // Update quantity
        inventoryManagement.updateQuantityByItemId(103, 12);
        System.out.println("Inventory after updating quantity of Item ID 103:");
        inventoryManagement.displayInventory();

        // Search for an item by ID
        Inventory searchedItem = inventoryManagement.searchByItemId(101);
        if (searchedItem != null) {
            System.out.println("Item found with ID 101: " + searchedItem.itemName);
        }

        // Calculate total value
        double totalValue = inventoryManagement.calculateTotalValue();
        System.out.println("Total inventory value: " + totalValue);
    }
}
