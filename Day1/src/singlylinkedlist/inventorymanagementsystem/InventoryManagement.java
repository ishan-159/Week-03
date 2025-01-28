package singlylinkedlist.inventorymanagementsystem;


public class InventoryManagement {
    private Item head = null;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemID, int quantity, double price) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (position == 1) {
            addAtBeginning(itemName, itemID, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds! Adding at the end.");
            addAtEnd(itemName, itemID, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove an item based on Item ID
    public void removeByItemID(int itemID) {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            System.out.println("Item with ID " + itemID + " removed.");
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemID != itemID) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item with ID " + itemID + " not found.");
        } else {
            prev.next = temp.next;
            System.out.println("Item with ID " + itemID + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityByItemID(int itemID, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(String itemName, int itemID) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: Name: " + temp.itemName + ", ID: " + temp.itemID +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String sortBy) {
        if (head == null || head.next == null) return; // No sorting needed for empty or single-item list
        boolean swapped;
        do {
            swapped = false;
            Item temp = head;
            while (temp.next != null) {
                boolean shouldSwap = false;
                if (sortBy.equalsIgnoreCase("name") && temp.itemName.compareToIgnoreCase(temp.next.itemName) > 0) {
                    shouldSwap = true;
                } else if (sortBy.equalsIgnoreCase("price") && temp.price > temp.next.price) {
                    shouldSwap = true;
                }
                if (shouldSwap) {
                    // Swap the data between nodes
                    String tmpName = temp.itemName;
                    int tmpID = temp.itemID;
                    int tmpQty = temp.quantity;
                    double tmpPrice = temp.price;

                    temp.itemName = temp.next.itemName;
                    temp.itemID = temp.next.itemID;
                    temp.quantity = temp.next.quantity;
                    temp.price = temp.next.price;

                    temp.next.itemName = tmpName;
                    temp.next.itemID = tmpID;
                    temp.next.quantity = tmpQty;
                    temp.next.price = tmpPrice;

                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by " + sortBy + ".");
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }
        System.out.println("Inventory List:");
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemID + ", Quantity: " + temp.quantity +
                    ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}


