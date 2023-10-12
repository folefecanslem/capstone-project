package com.example.capstone_project;

import androidx.appcompat.app.AppCompatActivity;

public class player extends AppCompatActivity {
    private int attack;
    private int defense;
    private int health;
    private int gold;

    public player(int attack, int defense, int health, int gold) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.gold = gold;
    }

    public void attack(dragonCave dragon) {
        int playerDamage = calculatePlayerDamage();
        System.out.println("You attacked the " + dragonCave.getType() + " dragon and dealt " + playerDamage + " damage.");
    }


    private int calculatePlayerDamage() {
        // Logic to calculate player damage based on attack, weapon, etc.
        return attack + inventory.getTotalWeaponDamage();
    }

    public void setAttack() {
        this.attack = 5;
    }

    public void setDefense() {
        this.defense = 5;
    }

    public void setHealth() {
        this.health = 5;
    }

    public int getGold() {
        return gold;
    }

    public void setGold() {
        this.gold = 100;
    }
    public static int getHealth() {
        return health;
    }
}
