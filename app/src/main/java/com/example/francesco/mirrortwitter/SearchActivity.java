package com.example.francesco.mirrortwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent i0=getIntent();
        String Name= i0.getStringExtra("Name");
        Intent i1= new Intent(SearchActivity.this, RisSearchActivity.class);
        i1.putExtra("Name",Name);

        button1 = findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(i1);
            }
        });

    }
}