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

public class CercaActivity extends AppCompatActivity {

    private Button butSear,butOpti,butHome,butCerc,butNoti,butMess;
    private String Value;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca);
        butSear = findViewById(R.id.button1);
        butOpti = findViewById(R.id.button7);
        butHome = findViewById(R.id.button3);
        butCerc = findViewById(R.id.button4);
        butNoti = findViewById(R.id.button5);
        butMess = findViewById(R.id.button6);

        EditText et = (EditText) findViewById(R.id.editText);

        butSear.setEnabled(false); // set button disable initially

        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

                if (s.toString().equals("")) {
                    butSear.setEnabled(false);
                } else {
                    butSear.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        View.OnClickListener gestore = new View.OnClickListener() {
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.button1:
                        Intent i1=new Intent(CercaActivity.this, SearchActivity.class);
                        Value=et.getText().toString();
                        i1.putExtra("Name",Value);
                        startActivity(i1);
                        break;
                    case R.id.button7:
                        Intent i2=new Intent(CercaActivity.this, OpzioniActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.button3:
                        Intent i3=new Intent(CercaActivity.this, MainActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.button4:
                        Intent i4=new Intent(CercaActivity.this, CercaActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.button5:
                        Intent i5=new Intent(CercaActivity.this, NotificheActivity.class);
                        startActivity(i5);
                        break;
                    case R.id.button6:
                        Intent i6=new Intent(CercaActivity.this, MessActivity.class);
                        startActivity(i6);
                        break;
                }
            }
        };

        butSear.setOnClickListener(gestore);
        butOpti.setOnClickListener(gestore);
        butHome.setOnClickListener(gestore);
        butCerc.setOnClickListener(gestore);
        butMess.setOnClickListener(gestore);
        butNoti.setOnClickListener(gestore);


        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] stuff = new String[]{"ItemCerca1", "ItemCerca2", "ItemCerca3", "ItemCerca4", "ItemCerca5", "ItemCerca6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, stuff);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent i = new Intent(CercaActivity.this, ItemActivity.class);
                i.putExtra("Item", stuff[pos]);
                startActivity(i);
            }
        });



    }




}
