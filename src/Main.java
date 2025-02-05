import inventory.Inventory;
import models.Item;
import models.Rarity;
import services.UpgradeService;

public class Main {
    public static void main(String[] args) {
        // Initialize the inventory and upgrade service
        Inventory inventory = new Inventory();
        UpgradeService upgradeService = new UpgradeService(inventory);

        // Test Case 1: Adding Items and Displaying Inventory
        System.out.println("Test Case 1: Adding Items and Displaying Inventory");
        inventory.addItem(new Item("Iron Sword", Rarity.COMMON));
        inventory.addItem(new Item("Iron Sword", Rarity.COMMON));
        inventory.addItem(new Item("Iron Sword", Rarity.COMMON));
        inventory.displayInventory();

        // Test Case 2: Upgrading Common → Great
        System.out.println("\nTest Case 2: Upgrading Common → Great");
        Item sword1 = inventory.getItemsByRarity(Rarity.COMMON).get(0);
        upgradeService.upgradeItem(sword1);
        inventory.displayInventory();

        // Adding another 'GREAT' item to allow upgrade
        System.out.println("\nFix: Adding another 'GREAT' item to allow upgrade");
        inventory.addItem(new Item("Iron Sword", Rarity.GREAT));
        inventory.displayInventory();

        // Test Case 3: Upgrading Great → Rare
        System.out.println("\nTest Case 3: Upgrading Great → Rare");
        Item sword2 = inventory.getItemsByRarity(Rarity.GREAT).get(0);
        upgradeService.upgradeItem(sword2);
        inventory.displayInventory();

        // Adding another 'RARE' item to allow upgrade
        System.out.println("\n Adding another 'RARE' item to allow upgrade");
        inventory.addItem(new Item("Iron Sword", Rarity.RARE));
        inventory.displayInventory();

        // Test Case 4: Upgrading Rare → Epic
        System.out.println("\nTest Case 4: Upgrading Rare → Epic");
        Item sword3 = inventory.getItemsByRarity(Rarity.RARE).get(0);
        upgradeService.upgradeItem(sword3);
        inventory.displayInventory();

        // Adding another 'EPIC' item for next upgrade
        System.out.println("\nFix: Adding another 'EPIC' item for next upgrade");
        inventory.addItem(new Item("Iron Sword", Rarity.EPIC));
        inventory.displayInventory();

        // Test Case 5: Upgrading Epic → Epic 1
        System.out.println("\nTest Case 5: Upgrading Epic → Epic 1");
        Item sword4 = inventory.getItemsByRarity(Rarity.EPIC).get(0);
        upgradeService.upgradeItem(sword4);
        inventory.displayInventory();

        // Adding another 'EPIC' item for next upgrade
        System.out.println("\nAdding another 'EPIC' item for next upgrade");
        inventory.addItem(new Item("Iron Sword", Rarity.EPIC));
        inventory.displayInventory();

        // Test Case 6: Upgrading Epic 1 → Epic 2
        System.out.println("\nTest Case 6: Upgrading Epic 1 → Epic 2");
        Item sword5 = inventory.getItemsByRarity(Rarity.EPIC_1).get(0);
        upgradeService.upgradeItem(sword5);
        inventory.displayInventory();

        // Adding another 'EPIC_2' item for final upgrade
        System.out.println("\nAdding another 'EPIC_2' item for final upgrade");
        inventory.addItem(new Item("Iron Sword", Rarity.EPIC_2));
        inventory.displayInventory();

        // Test Case 7: Upgrading Epic 2 → Legendary
        System.out.println("Test Case 7: Upgrading Epic 2 → Legendary");
        Item sword6 = inventory.getItemsByRarity(Rarity.EPIC_2).get(0);
        upgradeService.upgradeItem(sword6);
        inventory.displayInventory();

        // Test Case 8: Upgrading a Legendary Item
        System.out.println("\nTest Case 8: Upgrading a Legendary Item (Should Not Work)");
        Item sword7 = inventory.getItemsByRarity(Rarity.LEGENDARY).get(0);
        upgradeService.upgradeItem(sword7);
        inventory.displayInventory();

        //  Test Case 9: Not Enough Items to Upgrade
        System.out.println("\n Test Case 9: Not Enough Items to Upgrade ");
        Item sword8 = new Item("Bronze Dagger", Rarity.COMMON);
        inventory.addItem(sword8);
        upgradeService.upgradeItem(sword8);
        inventory.displayInventory();
    }
}