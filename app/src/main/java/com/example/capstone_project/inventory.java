package com.example.capstone_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class inventory extends AppCompatActivity {
    User user= new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
    }



    private void showInventory() {
        // Display the user's inventory
        StringBuilder inventoryText = new StringBuilder("Inventory:\n");
        for (Item item : user.getInventory()) {
            inventoryText.append(item.getName()).append(" - Damage: ").append(item.getDamage())
                    .append(", Price: ").append(item.getPrice()).append("\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Inventory")
                .setMessage(inventoryText.toString())
                .setPositiveButton("OK", null)
                .show();
    }
}