package com.example.capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dragonCave extends AppCompatActivity {

    public static String type;
    public static String getType() {
        return type;

    }
    public static int getHealth() {
        return health;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragon_cave);
    }

    private int level;
    private int attack;
    private int defense;
    private static int health;

    public dragonCave(int level, int attack, int defense, int health) {
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setAttack() {
        this.attack = 5;
    }
    public  void setDefense() {
        this.defense = 5;
    }
    public  void setHealth() {
        this.health = 5;
    }


}