package com.example.francesco.mirrortwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button butOpti,butHome,butCerc,butNoti,butMess;
    private String Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butOpti = findViewById(R.id.button7);
        butHome = findViewById(R.id.button3);
        butCerc = findViewById(R.id.button4);
        butNoti = findViewById(R.id.button5);
        butMess = findViewById(R.id.button6);



        View.OnClickListener gestore = new View.OnClickListener() {
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.button7:
                        Intent i2=new Intent(MainActivity.this, OpzioniActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.button3:
                        Intent i3=new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.button4:
                        Intent i4=new Intent(MainActivity.this, CercaActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.button5:
                        Intent i5=new Intent(MainActivity.this, NotificheActivity.class);
                        startActivity(i5);
                        break;
                    case R.id.button6:
                        Intent i6=new Intent(MainActivity.this, MessActivity.class);
                        startActivity(i6);
                        break;
                }
            }
        };

        butOpti.setOnClickListener(gestore);
        butHome.setOnClickListener(gestore);
        butCerc.setOnClickListener(gestore);
        butMess.setOnClickListener(gestore);
        butNoti.setOnClickListener(gestore);


        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] stuff = new String[]{"ItemMain1", "ItemMain2", "ItemMain3", "ItemMain4", "ItemMain5", "ItemMain6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, stuff);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent i = new Intent(MainActivity.this, ItemActivity.class);
                i.putExtra("Item", stuff[pos]);
                startActivity(i);
            }
        });



    }




}
