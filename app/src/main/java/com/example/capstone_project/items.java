package com.example.capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class items extends AppCompatActivity {
    private String name;
    private int damage;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }
}