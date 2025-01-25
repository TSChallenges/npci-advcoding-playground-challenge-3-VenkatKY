import java.io.*;
import java.util.*;

public class InventoryManager {

public static void main(String[] args) {
		// Entry point for the program
		// TODO: Implement menu-driven program for inventory management
		String fileName = "C:\\6MBCDT\\Inventory.txt";
		readInventory(fileName);
		System.out.println();
		
		addItem(fileName, "coconut", 9);
		System.out.println();

		readInventory(fileName);

	}

	public static void readInventory(String fileName) {
		// TODO: Read and display inventory from file
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("The Inventory File Doesnot Exist");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			System.out.println("Current Inventory:");
			System.out.println("------------------");

			boolean isEmpty = true; // Flag to check if the file is empty
			while ((line = reader.readLine()) != null) {
				isEmpty = false;
				System.out.println(line); // Print each line (representing an inventory item)
			}

			if (isEmpty) {
				System.out.println("The inventory is empty.");
			}
		} catch (IOException e) {
			System.out.println("Error reading the inventory file: " + e.getMessage());
		}
	}

	public static void addItem(String fileName, String itemName, int itemCount) {
		// TODO: Add a new item to the inventory
		File file = new File(fileName);
		List<String> inventoryItems = new ArrayList<>();

		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = reader.readLine()) != null) {
					inventoryItems.add(line);
				}
			} catch (IOException e) {
				System.out.println("Error Reading the Inventory File: " + e.getMessage());
				return;
			}

			String newItem = itemName + "," + itemCount;
			inventoryItems.add(newItem);

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (String item : inventoryItems) {
					writer.write(item);
					writer.newLine();
				}
				System.out.println("Item '" + itemName + "' Added Successfully With Quantity");
			} catch (IOException e) {
				System.out.println("Error Updating Inventory File : " + e.getMessage());
			}

		}

	}
// }


    public static void updateItem(String fileName, String itemName, int itemCount) {
        // TODO: Update the count of an existing item
    }
}
