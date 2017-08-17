package com.blovvme.w3d3restfulandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.blovvme.w3d3restfulandrecyclerview.model.Grf;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Log Response";
    public static final String BASE_URL = "https://api.github.com/users/germanrodz";
    Button btnHttpCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHttpCall = (Button) findViewById(R.id.btnHttpCall);
    }

    String resultResponse = " ";
    Grf grf;

    public void onHttpCall(View view) {

        Log.d(TAG, "makingRestCalls: ");
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
                resultResponse = response.body().string();
                Gson gson = new Gson();
                 grf = gson.fromJson(resultResponse, Grf.class);
                Log.d(TAG, "onResponse: " + grf.getFollowers());


                //Pass this to the recyclerview
                //weatherData.getList();

            }
        });
    }
}
