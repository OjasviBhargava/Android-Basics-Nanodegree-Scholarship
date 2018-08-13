package com.example.ojasvi.punjabtourguide;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView patiala = (TextView) findViewById(R.id.patiala);
        patiala.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent patialaIntent = new Intent(MainActivity.this, PatialaActivity.class);
                startActivity(patialaIntent);
            }
        });

        TextView jalandhar = (TextView) findViewById(R.id.jalandhar);
        jalandhar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jalandharIntent = new Intent(MainActivity.this, JalandharActivity.class);
                startActivity(jalandharIntent);
            }
        });

        TextView chandigarh = (TextView) findViewById(R.id.chandigarh);
        chandigarh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chandigarhIntent = new Intent(MainActivity.this, ChandigarhActivity.class);
                startActivity(chandigarhIntent);
            }
        });

        TextView amritsar = (TextView) findViewById(R.id.amritsar);
        amritsar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent amritsarIntent = new Intent(MainActivity.this, AmritsarActivity.class);
                startActivity(amritsarIntent);
            }
        });
    }
}
