package com.example.capstone_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class shop extends AppCompatActivity {
    private Button buy;
    TextView userStatus;
    TextView dragonStatus;
    private Button sell;
    User user= new User();
    Dragon dragon= new Dragon();

    private static List<Item> items;

    public shop() {
        items = new ArrayList<>();
        // Add some items to the shop
        items.add(new Item("Sword", 20, 50));
        items.add(new Item("Armor", 10, 30));
        items.add(new Item("Potion", 5, 10));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        buy = findViewById(R.id.buy);
        sell = findViewById(R.id.sell);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement buy logic
                buyItem();
                // Update user and dragon status
                updateStatusViews();
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement sell logic
                sellItem();
                // Update user and dragon status
                updateStatusViews();
            }
        });
    }
    void updateStatusViews() {
        // Update TextViews with user and dragon status
        userStatus.setText("User Status: " + user.getStatus());
        dragonStatus.setText("Dragon Status: " + dragon.getStatus());
    }

    public static List<Item> getItems() {
        return items;
    }

    public static Item getItem(int index) {
        return items.get(index);
    }



    void checkGameResult() {
        // Check if the game is over (lives of user or dragon reached 0)
        if (user.getHealth() <= 0) {
            // User loses
            showGameOverDialog("You lost! Try again.");
        } else if (dragon.getLives() <= 0) {
            // User wins
            showGameOverDialog("Congratulations! You won!");
        }
    }

    private void showGameOverDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Reset the game or navigate to a new activity
                        // For simplicity, let's just finish the current activity
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void buyItem() {
        // the user buys the first item in the shop
        Item item = shop.getItem(0);
        if (user.getGoldCoins() >= item.getPrice()) {
            user.buyItem(item);
        } else {
            Toast.makeText(this, "Not enough gold coins!", Toast.LENGTH_SHORT).show();
        }
    }

    private void sellItem() {
        // For simplicity, let's assume the user sells the first item in their inventory
        if (!user.getInventory().isEmpty()) {
            Item item = user.getItem(0);
            user.sellItem(item);
        } else {
            Toast.makeText(this, "Inventory is empty!", Toast.LENGTH_SHORT).show();
        }
    }

}
