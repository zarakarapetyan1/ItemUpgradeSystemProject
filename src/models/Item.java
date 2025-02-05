package models;

public class Item {
    private final String name;  // Name of the item
    private Rarity rarity;  // Rarity of the item
    private int upgradeCount;  // Tracks the number of upgrades the item has undergone

    // Constructor to initialize the item with a name, rarity, and default upgrade count
    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return name;
    }  // Returns the name of the item

    public Rarity getRarity() {
        return rarity;
    }  // Returns the rarity of the item

    public int getUpgradeCount() {
        return upgradeCount;
    }  // Returns the upgrade count of the item

    // Sets a new rarity for the item and resets upgrade count for specific rarities
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
        if (rarity == Rarity.EPIC_1 || rarity == Rarity.EPIC_2) {
            upgradeCount = 0;  // Reset upgrade count for EPIC_1 and EPIC_2
        }
    }

    // Increments the upgrade count by 1
    public void incrementUpgradeCount() {
        this.upgradeCount++;
    }

    // Resets the upgrade count to 0
    public void resetUpgradeCount() {
        this.upgradeCount = 0;
    }

    // Custom toString to display item details, including upgrade count for specific rarities
    @Override
    public String toString() {
        return name + " (" + rarity + (rarity == Rarity.EPIC || rarity == Rarity.EPIC_1 || rarity == Rarity.EPIC_2 ? " " + upgradeCount : "") + ")";
    }
}