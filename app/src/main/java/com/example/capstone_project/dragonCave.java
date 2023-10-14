package com.example.capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class dragonCave extends AppCompatActivity {
    Button blue;
    Button red;
    Button green;
    Button gold;
    Button black;
    User user= new User();
    Dragon dragon= new Dragon();
    shop shop= new shop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragon_cave);

        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        green = findViewById(R.id.green);
        black = findViewById(R.id.black);
        gold = findViewById(R.id.gold);
    }


    private void chooseDragonCave() {
        // Implement logic for the user to choose a dragon cave
        // the player always chooses the first cave
        startDragonBattle();
    }

    private void startDragonBattle() {
        // Implement logic for the dragon battle
        // For simplicity, let's assume the battle is automatic
        while (user.getHealth() > 0 && dragon.getLives() > 0) {
            user.attack(dragon);
            dragon.attack(user);
        }
        shop.checkGameResult();
        shop.updateStatusViews();
    }

}