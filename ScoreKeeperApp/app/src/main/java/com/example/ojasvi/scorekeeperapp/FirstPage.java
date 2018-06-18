package com.example.ojasvi.scorekeeperapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        // init view
        Button mButton = findViewById(R.id.but1);

    }

    /*
    Launch Main Activity on click
     */
    public void launchGame(View view) {
        Intent intent = new Intent(FirstPage.this,MainActivity.class);
        startActivity(intent);
    }
}
