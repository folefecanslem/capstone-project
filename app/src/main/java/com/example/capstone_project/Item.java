package com.example.capstone_project;

public class Item {
    private String name;
    private int damage;
    private int price;

    public Item(String name, int damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }
}

