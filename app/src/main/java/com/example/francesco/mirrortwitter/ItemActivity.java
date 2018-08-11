package com.example.francesco.mirrortwitter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.example.francesco.mirrortwitter.Network.OkHttpProvider;

public class ItemActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        String finaValue;
        String value;


        Intent i= getIntent();
        value = i.getStringExtra("Item");
        TextView title = findViewById(R.id.textView4);

        if(value.contains("ItemMain")) {
            finaValue = value + " Lista Main";
            title.setText(finaValue);

        }else if(value.contains("ItemNotifiche")) {
            finaValue= value + "  Lista Notifiche";
            title.setText(finaValue);

        }else if (value.contains("ItemMess")) {
            finaValue= value + "Lista Messaggi ";
            title.setText(finaValue);

        }else if(value.contains("ItemCerca")) {
            finaValue = value + "Lista Risultati Cercati";
            title.setText(finaValue);
        }


        handler = new Handler(getMainLooper());
        getUrl();

    }

    private void getUrl() {

        Intent i =getIntent();
        String value = i.getStringExtra("Item");


        OkHttpClient client = OkHttpProvider.getInstance().getOkHttpClient();
        Request request = new Request.Builder().url("https://it.wikipedia.org/wiki/"+value).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(() -> {
                    TextView tv = (TextView) findViewById(R.id.textView);
                    try {
                        tv.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

    }

}

