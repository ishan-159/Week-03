package singlylinkedlist.inventorymanagementsystem;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Adding items
        inventory.addAtEnd("Item1", 101, 10, 5.5);
        inventory.addAtBeginning("Item2", 102, 5, 12.0);
        inventory.addAtPosition(2, "Item3", 103, 8, 7.5);

        // Display inventory
        inventory.displayInventory();
        System.out.println();

        // Search for an item
        inventory.searchItem("Item3", 0);
        System.out.println();

        // Update quantity
        inventory.updateQuantityByItemID(103, 15);
        inventory.displayInventory();
        System.out.println();

        // Calculate total value
        inventory.calculateTotalValue();
        System.out.println();

        // Sort by name
        inventory.sortInventory("name");
        inventory.displayInventory();
        System.out.println();

        // Remove an item
        inventory.removeByItemID(102);
        inventory.displayInventory();
    }
}
