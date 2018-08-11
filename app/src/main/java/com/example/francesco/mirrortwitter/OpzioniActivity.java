package com.example.francesco.mirrortwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpzioniActivity extends AppCompatActivity {

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opzioni);


        but1 = findViewById(R.id.button3);
        but2 = findViewById(R.id.button4);
        but3 = findViewById(R.id.button5);
        but4 = findViewById(R.id.button6);


        View.OnClickListener gestore = new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button3:
                        Intent i0 = new Intent(OpzioniActivity.this, OptionModified.class);
                        i0.putExtra("opt", "1");
                        startActivity(i0);
                        break;
                    case R.id.button4:
                        Intent i1 = new Intent(OpzioniActivity.this, OptionModified.class);
                        i1.putExtra("opt", "2");
                        startActivity(i1);
                        break;
                    case R.id.button6:
                        Intent i2 = new Intent(OpzioniActivity.this, OptionModified.class);
                        i2.putExtra("opt", "3");
                        startActivity(i2);
                        break;
                    case R.id.button5:
                        Intent i3 = new Intent(OpzioniActivity.this, OptionModified.class);
                        i3.putExtra("opt", "4");
                        startActivity(i3);
                        break;

                }
            }
        };

        but1.setOnClickListener(gestore);
        but2.setOnClickListener(gestore);
        but3.setOnClickListener(gestore);
        but4.setOnClickListener(gestore);

    }

}