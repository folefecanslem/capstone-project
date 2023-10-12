package com.example.capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button inventory;
    Button shop;
    Button cave;
    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inventory =  findViewById(R.id.inventory);
        shop =  findViewById(R.id.shop);
        cave =  findViewById(R.id.cave);
        quit =  findViewById(R.id.quit);
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

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle shop logic
                Toast.makeText(MainActivity.this, "Shop selected", Toast.LENGTH_SHORT).show();
            }
        });

        cave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle dragon cave logic
                spawnDragon();
                battle();
            }
        });
    }

    private void spawnDragon() {
        Random random = new Random();
        int level = random.nextInt(5) + 1;


    }

    private void battle() {

    }

    public boolean checkGameOver() {
        if (player.getHealth() <= 0) {
            System.out.println("Game Over! You were defeated by the dragon.");
            return true;
        } else if (dragonCave.getHealth() <= 0) {
            System.out.println("Congratulations! You defeated the dragon!");
            return true;
        }
        return false;
    }
}


