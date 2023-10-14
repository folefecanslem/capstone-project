package com.example.capstone_project;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int goldCoins;
    private int health;
    private List<Item> inventory;
    private static List<Item> items;


    public User() {
        this.goldCoins = 100;
        this.health = 10; // Initial health for the user
        this.inventory = new ArrayList<>();
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getHealth() {
        return health;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void attack(Dragon dragon) {
        // Implement attack logic
        int damage = 10; // Placeholder for damage calculation
        dragon.takeDamage(damage);
    }

    public void defend() {
        // Implement defend logic
        // Reduce user's vulnerability, increase defense, etc.
    }

    public void takeDamage(int damage) {
        // Implement logic for the user taking damage
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void buyItem(Item item) {
        if (goldCoins >= item.getPrice()) {
            goldCoins -= item.getPrice();
            inventory.add(item);
        }
    }

    public void sellItem(Item item) {
        if (inventory.contains(item)) {
            goldCoins += item.getPrice();
            inventory.remove(item);
        }
    }
    public static Item getItem(int index) {
        return items.get(index);
    }
    public String getStatus() {
        return "Health: " + health + " Gold Coins: " + goldCoins;
    }
}

