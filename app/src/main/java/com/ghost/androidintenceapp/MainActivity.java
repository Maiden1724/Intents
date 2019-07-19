package com.ghost.androidintenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mbtnexplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnexplore = findViewById(R.id.btnexplore);
        mbtnexplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tembea= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(tembea);
            }
        });
    }
}
