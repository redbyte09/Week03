package com.linkedlist.inventrymanagment;

public class Inventory {
     String itemName;
     int itemId;
     double quantity;
     double price;
     Inventory next;

     public Inventory(String itemName, int itemId, double quantity, double price) {
         this.itemName = itemName;
         this.itemId = itemId;
         this.quantity = quantity;
         this.price = price;
         next = null;

     }
}
