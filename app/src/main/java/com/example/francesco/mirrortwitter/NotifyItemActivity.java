package com.example.francesco.mirrortwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NotifyItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_item);
        Intent i= getIntent();
        String tipo=i.getStringExtra("tipo");
        final String[] stuff;


        ListView listView = (ListView) findViewById(R.id.listview);
            if(tipo.equals("Tutti")) {
               stuff = new String[]{"ItemTutti1", "ItemTutti2", "ItemTutti3", "ItemTutti4", "ItemTutti5", "ItemTutti6"};

            }else {
                stuff = new String[]{"ItemMenz1", "ItemMenz2", "ItemMenz3", "ItemMenz4", "ItemMenz5", "ItemMenz6"};


            }

            ArrayAdapter<String> arrayAdapter =
                    new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, stuff);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                    Intent i = new Intent(NotifyItemActivity.this, ItemActivity.class);
                    i.putExtra("Item", stuff[pos]);
                    startActivity(i);
                }
            });

        }
        }

