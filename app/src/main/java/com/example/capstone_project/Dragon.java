package com.example.capstone_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Dragon extends AppCompatActivity {
    private int level;
    private int lives;
    private int health;
    User user= new User();
    shop shop = new shop();
    Dragon dragon= new Dragon();

    public Dragon() {
        // Initialize dragon with a random level between 1 and 5
        Random random = new Random();
        this.level = random.nextInt(5) + 1;
        this.lives = 3; // Set an initial number of lives for the dragon
        this.health = 10; // Initial health for the dragon
    }

    public int getLevel() {
        return level;
    }

    public int getLives() {
        return lives;
    }

    public int getHealth() {
        return health;
    }

    public void attack(User user) {
        // Implement attack logic
        int damage = 8; // Placeholder for damage calculation
        user.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        // Implement logic for the dragon taking damage
        health -= damage;
        if (health < 0) {
            health = 0;
            // Dragon loses a life or handle defeat logic
            lives--;
            if (lives <= 0) {
                // Dragon defeated, handle game over logic
            } else {
                // Dragon respawns or continue with the game
                health = 10; // Reset dragon health
            }
        }
    }

    public String getStatus() {
        return "Level: " + level + " Lives: " + lives + " Health: " + health;
    }



    // ...

    private boolean isDragonBattleOngoing = false;

// ... (Other code)

    private void startDragonBattle() {
        if (!isDragonBattleOngoing) {
            isDragonBattleOngoing = true;

            // Assume the user chooses a random level for the dragon for simplicity
            int dragonLevel = (int) (Math.random() * 5) + 1;
            Dragon dragon = new Dragon();

            shop.updateStatusViews();
            showBattleDialog(dragon);
        } else {
            Toast.makeText(this, "Dragon battle is already ongoing", Toast.LENGTH_SHORT).show();
        }
    }

    private void showBattleDialog(final Dragon dragon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dragon Battle")
                .setMessage("A level " + dragon.getLevel() + " dragon appears! What will you do?")
                .setPositiveButton("Attack", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User attacks dragon
                        user.attack(dragon);

                        // Dragon attacks user
                        dragon.attack(user);

                        // Check if the battle is over
                        checkBattleResult(dragon);
                    }
                })
                .setNegativeButton("Defend", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User defends against dragon's attack
                        user.defend();

                        // Dragon attacks user
                        dragon.attack(user);

                        // Check if the battle is over
                        checkBattleResult(dragon);
                    }
                })
                .setNeutralButton("Flee", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User attempts to flee (add fleeing logic)
                        fleeFromBattle();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void fleeFromBattle() {
        //the user always fails to flee
        user.takeDamage(10); // User takes damage for failed flee attempt

        // Dragon attacks user
        dragon.attack(user);

        // Check if the battle is over
        checkBattleResult(dragon);
    }

    private void checkBattleResult(Dragon dragon) {
        shop.updateStatusViews();

        if (user.getHealth() <= 0) {
            // User loses
            showBattleResultDialog("Sorry You lost");
        } else if (dragon.getLives() <= 0) {
            // User wins
            showBattleResultDialog("Congratulations! You Escape Death");
        } else {
            // Continue the battle
            showBattleDialog(dragon);
        }
    }

    private void showBattleResultDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Battle Result")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Reset battle flag
                        isDragonBattleOngoing = false;

                        // Update user and dragon status
                        shop.updateStatusViews();
                    }
                })
                .setCancelable(false)
                .show();
    }

}

