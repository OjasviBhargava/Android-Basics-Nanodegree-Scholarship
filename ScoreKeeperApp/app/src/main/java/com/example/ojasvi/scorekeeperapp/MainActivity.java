package com.example.ojasvi.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String ARCHER_KEY1 = "archer1";
    private static final String ARCHER_KEY2 = "archer2";


    private  int score_A1;               //score for Archer A
    private int score_A2;               //score for Archer B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            score_A1 = savedInstanceState.getInt(ARCHER_KEY1,0);
            score_A2 = savedInstanceState.getInt(ARCHER_KEY2,0);
        }

        displayA1(score_A1);                         // For displaying score for Archer A
        displayA2(score_A2);                        //  For displaying score for Archer B

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARCHER_KEY1, score_A1);
        outState.putInt(ARCHER_KEY2, score_A2);
    }

    int newA1 = 0;
    int newA2 = 0;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        newA1 = savedInstanceState.getInt("archer1",0);
        newA2 = savedInstanceState.getInt("archer2",0);
    }


    public void displayA1(int score) {
        TextView scoreView =  findViewById(R.id.archer_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayA2(int score) {
        TextView scoreView = findViewById(R.id.archer_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add10ForArch1 (View view) {
        score_A1 = score_A1 + 10;
        displayA1(score_A1);

    }

    public void add10ForArch2 (View view) {
        score_A2 = score_A2 + 10;
        displayA2(score_A2);

    }
    public void add9ForArch1 (View view) {
        score_A1 = score_A1 + 9;
        displayA1(score_A1);

    }

    public void add9ForArch2 (View view) {
        score_A2 = score_A2 + 9;
        displayA2(score_A2);

    }
    public void add8ForArch1 (View view) {
        score_A1 = score_A1 + 8;
        displayA1(score_A1);

    }

    public void add8ForArch2 (View view) {
        score_A2 = score_A2 + 8;
        displayA2(score_A2);

    }
    public void add7ForArch1 (View view) {
        score_A1 = score_A1 + 7;
        displayA1(score_A1);

    }

    public void add7ForArch2 (View view) {
        score_A2 = score_A2 + 7;
        displayA2(score_A2);

    }

    public void add6ForArch1 (View view) {
        score_A1 = score_A1 + 6;
        displayA1(score_A1);

    }

    public void add6ForArch2 (View view) {
        score_A2 = score_A2 + 6;
        displayA2(score_A2);

    }

    public void add5ForArch1 (View view) {
        score_A1 = score_A1 + 5;
        displayA1(score_A1);

    }

    public void add5ForArch2 (View view) {
        score_A2 = score_A2 + 5;
        displayA2(score_A2);

    }
    public void add4ForArch1 (View view) {
        score_A1 = score_A1 + 4;
        displayA1(score_A1);

    }

    public void add4ForArch2 (View view) {
        score_A2 = score_A2 +4;
        displayA2(score_A2);

    }

    public void add3ForArch1 (View view) {
        score_A1 = score_A1 + 3;
        displayA1(score_A1);

    }

    public void add3ForArch2 (View view) {
        score_A2 = score_A2 + 3;
        displayA2(score_A2);

    }

    public void add2ForArch1 (View view) {
        score_A1 = score_A1 + 2;
        displayA1(score_A1);

    }

    public void add2ForArch2 (View view) {
        score_A2 = score_A2 + 2;
        displayA2(score_A2);

    }

    public void add1ForArch1 (View view) {
        score_A1 = score_A1 + 1;
        displayA1(score_A1);

    }

    public void add1ForArch2 (View view) {
        score_A2 = score_A2 + 1;
        displayA2(score_A2);

    }

    //for resetting the score

    public void ResetAll (View view) {
        score_A1 = 0;
        score_A2 = 0;
        displayA1(0);
        displayA2(0);
    }
}