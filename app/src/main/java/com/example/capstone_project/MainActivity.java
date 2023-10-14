package com.example.capstone_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {


    Button inventory;
    Button shop;
    Button cave;
    Button quit;

    User user= new User();
    Dragon dragon= new Dragon();
    shop Shop= new shop();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inventory = findViewById(R.id.inventory);
        shop = findViewById(R.id.shop);
        cave = findViewById(R.id.cave);
        quit = findViewById(R.id.quit);


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, inventory.class));
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, shop.class));
            }
        });
        cave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, dragonCave.class));
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        }


    private void openShop() {
        // Display items in the shop
        StringBuilder shopText = new StringBuilder("Shop:\n");
        for (Item item : Shop.getItems()) {
            shopText.append(item.getName()).append(" - Damage: ").append(item.getDamage())
                    .append(", Price: ").append(item.getPrice()).append("\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Shop")
                .setMessage(shopText.toString())
                .setPositiveButton("OK", null)
                .show();
    }

    }








//    private void spawnDragon() {
//        Random random = new Random();
//        int level = random.nextInt(5) + 1;
//
//
//    }
//
//
//    public boolean checkGameOver() {
//        if (player.getHealth() <= 0) {
//            System.out.println("Game Over! You were defeated by the dragon.");
//            return true;
//        } else if (dragonCave.getHealth() <= 0) {
//            System.out.println("Congratulations! You defeated the dragon!");
//            return true;
//        }
//        return false;
//    }



