package inventory;

import models.Item;
import models.Rarity;

import java.util.*;

public class Inventory {
    // Map to store items categorized by rarity
    private final Map<Rarity, List<Item>> items;

    // Constructor initializes the inventory for all rarity levels
    public Inventory() {
        items = new HashMap<>();
        for (Rarity rarity : Rarity.values()) {
            items.put(rarity, new ArrayList<>());
        }
    }

    // Adds an item to the inventory based on its rarity
    public void addItem(Item item) {
        items.get(item.getRarity()).add(item);
    }

    // Retrieves all items of a specific rarity
    public List<Item> getItemsByRarity(Rarity rarity) {
        return items.get(rarity);
    }

    // Checks if there are enough items of a specific rarity and name
    public boolean hasSufficientItems(Rarity rarity, String name, int count) {
        return items.get(rarity).stream().filter(item -> item.getName().equals(name)).count() >= count;
    }

    // Removes a specified number of items of a certain name and rarity from the inventory
    public void removeItems(Rarity rarity, String name, int count) {
        List<Item> itemList = items.get(rarity);
        Iterator<Item> iterator = itemList.iterator();
        int removedCount = 0;

        // Remove items until the specified count is reached
        while (iterator.hasNext() && removedCount < count) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                removedCount++;
            }
        }
    }

    // Moves an item to a new rarity level after an upgrade
    public void moveItemToNewRarity(Item item, Rarity newRarity) {
        items.get(item.getRarity()).remove(item);  // Remove from old rarity list
        item.setRarity(newRarity);  // Upgrade rarity
        items.get(newRarity).add(item);  // Add to new rarity list
    }

    // Displays the current inventory grouped by rarity
    public void displayInventory() {
        System.out.println("\n===== Inventory =====");
        // Loop through each rarity level and display items
        for (Rarity rarity : Rarity.values()) {
            List<Item> itemList = items.get(rarity);
            if (!itemList.isEmpty()) {
                System.out.println(rarity + ":");
                itemList.forEach(item -> System.out.println("  - " + item));
            }
        }
    }
}
