package com.blovvme.w3d3restfulandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.blovvme.w3d3restfulandrecyclerview.model.Grf;
import com.blovvme.w3d3restfulandrecyclerview.model.Repo;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends AppCompatActivity {

    public static final String URL = "https://api.github.com/users/germanrodz/repos";
    List<Repo> grfList = new ArrayList<>();
    Repo[] reposList;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    GrfRecyclerViewAdapter grfRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        rv = (RecyclerView) findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(itemAnimator);

        getRepos();
        //initialize adapter


    }

    public void getRepos(){
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //resultResponse = response.body().string();
                Gson gson = new Gson();
                reposList = gson.fromJson(response.body().string(), Repo[].class);
                for (int i = 0; i < reposList.length;i++){
                    grfList.add(reposList[i]);
                }

                updateUI();

            }
        });
    }

    public void updateUI(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                grfRecyclerViewAdapter = new GrfRecyclerViewAdapter(grfList);
                rv.setAdapter(grfRecyclerViewAdapter);
                grfRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

}
