package com.example.francesco.mirrortwitter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.francesco.mirrortwitter.Network.OkHttpProvider;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OptionModified extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_modified);

        handler = new Handler(getMainLooper());
        getUrl();

    }

    private void getUrl() {

        Intent i =getIntent();
        String value = i.getStringExtra("opt");


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
