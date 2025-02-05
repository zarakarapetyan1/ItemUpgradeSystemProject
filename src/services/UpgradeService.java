package services;

import inventory.Inventory;
import models.Item;
import models.Rarity;

public class UpgradeService {
    private final Inventory inventory;  // Inventory instance for managing items

    public UpgradeService(Inventory inventory) {
        this.inventory = inventory;  // Initialize with an existing inventory
    }

    // Main method for upgrading items based on their current rarity
    public void upgradeItem(Item item) {
        Rarity rarity = item.getRarity();
        String name = item.getName();

        switch (rarity) {
            case COMMON -> upgradeItemTier(item, Rarity.GREAT);  // Upgrade from COMMON to GREAT
            case GREAT -> upgradeItemTier(item, Rarity.RARE);   // Upgrade from GREAT to RARE
            case RARE -> upgradeItemTier(item, Rarity.EPIC);    // Upgrade from RARE to EPIC
            case EPIC -> upgradeEpic(item);  // Upgrade from EPIC to EPIC_1
            case EPIC_1 -> upgradeEpic1(item);  // Upgrade from EPIC_1 to EPIC_2
            case EPIC_2 -> upgradeEpic2(item);  // Upgrade from EPIC_2 to LEGENDARY
            case LEGENDARY -> System.out.println(name + " is already Legendary and cannot be upgraded.");
        }
    }

    // Upgrades the item from one rarity tier to the next (e.g., COMMON -> GREAT)
    private void upgradeItemTier(Item item, Rarity to) {
        Rarity from = item.getRarity();
        if (inventory.hasSufficientItems(from, item.getName(), 2)) {
            inventory.removeItems(from, item.getName(), 2);  // Remove 2 items of current rarity
            inventory.moveItemToNewRarity(item, to);  // Move the upgraded item to new rarity
            System.out.println("Upgraded " + item.getName() + " to " + to + "!");
        } else {
            System.out.println("Not enough " + from + " items to upgrade " + item.getName());
        }
    }

    // Upgrades an EPIC item to EPIC_1
    private void upgradeEpic(Item item) {
        if (inventory.hasSufficientItems(Rarity.EPIC, item.getName(), 1)) {
            inventory.removeItems(Rarity.EPIC, item.getName(), 1);  // Remove 1 EPIC item
            inventory.moveItemToNewRarity(item, Rarity.EPIC_1);  // Move to EPIC_1
            System.out.println(item.getName() + " upgraded to EPIC 1!");
        } else {
            System.out.println("Not enough EPIC items to upgrade " + item.getName());
        }
    }

    // Upgrades an EPIC_1 item to EPIC_2
    private void upgradeEpic1(Item item) {
        if (inventory.hasSufficientItems(Rarity.EPIC, item.getName(), 1)) {
            inventory.removeItems(Rarity.EPIC, item.getName(), 1);  // Remove 1 EPIC item
            inventory.moveItemToNewRarity(item, Rarity.EPIC_2);  // Move to EPIC_2
            System.out.println(item.getName() + " upgraded to EPIC 2!");
        } else {
            System.out.println("Not enough EPIC items to upgrade " + item.getName());
        }
    }

    // Upgrades an EPIC_2 item to LEGENDARY
    private void upgradeEpic2(Item item) {
        if (inventory.hasSufficientItems(Rarity.EPIC_2, item.getName(), 2)) {
            inventory.removeItems(Rarity.EPIC_2, item.getName(), 2);  // Remove 2 EPIC_2 items
            inventory.moveItemToNewRarity(item, Rarity.LEGENDARY);  // Move to LEGENDARY
            System.out.println(item.getName() + " upgraded to LEGENDARY!");
        } else {
            System.out.println("Not enough EPIC 2 items to upgrade to LEGENDARY.");
        }
    }

    // This method seems to be a duplicate; it could be refactored or removed based on the specific use case
    private void upgradeItemTier(Item item, Rarity from, Rarity to, String name) {
        if (!inventory.hasSufficientItems(from, name, 2)) {
            System.out.println("Not enough " + from + " items to upgrade " + name);
            return;  // Exit early if not enough items
        }

        inventory.removeItems(from, name, 2);  // Remove 2 items of the current rarity
        item.setRarity(to);  // Set the new rarity
        System.out.println("Upgraded " + name + " to " + to + "!");
    }
}