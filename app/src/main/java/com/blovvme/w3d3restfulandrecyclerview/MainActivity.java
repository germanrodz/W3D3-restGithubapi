package com.blovvme.w3d3restfulandrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blovvme.w3d3restfulandrecyclerview.model.Grf;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "Recyclerview";
    private static String BASE_URL = "https://api.github.com/users/germanrodz";
    private Grf grf;

    TextView tvLogin;
    TextView tvId;
    TextView tvHtml_Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvId = (TextView) findViewById(R.id.tvId);
        tvHtml_Url = (TextView) findViewById(R.id.tvHtml_Url);
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //resultResponse = response.body().string();
                Gson gson = new Gson();
                grf = gson.fromJson(response.body().string(), Grf.class);
//gfdgd
                updateUI();

            }
        });


    }


    public void updateUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvLogin.setText(grf.getLogin());
                tvId.setText(grf.getId().toString());
                tvHtml_Url.setText(grf.getHtmlUrl().toString());
            }
        });
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}//
