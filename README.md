# Item Upgrade System

## Description:
The Item Upgrade System is a Java-based application that allows
players to upgrade items through various rarity levels (e.g., Common → Great → Rare → Epic → Legendary).
The system manages items and ensures that players have enough resources to perform upgrades.

## Features:
- Items can be upgraded based on their rarity.
- Players need to have sufficient quantities of the current rarity to upgrade to the next tier.

## Assumptions:
- Each item has a specific rarity (e.g., COMMON, GREAT, RARE, etc.).
- Upgrades require 2 items of the current rarity, except for the final stages (EPIC → LEGENDARY).

## Design Choices:
- The system uses object-oriented principles like encapsulation, inheritance, and polymorphism to handle the logic of item upgrades.
- Inventory is managed using an `Inventory` class, and upgrades are performed using the `UpgradeService` class.
- The program uses enums to represent item rarities.

## Instructions:
1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA or any other IDE that supports Java.
3. Compile and run the `Main` class to test the system.

## To Run:
You can run the project from IntelliJ IDEA:
1. Open the `ItemUpgradeSystem` project.
2. Navigate to `Main.java` and run it as a Java application.

## Dependencies:
- Java 17 or higher.