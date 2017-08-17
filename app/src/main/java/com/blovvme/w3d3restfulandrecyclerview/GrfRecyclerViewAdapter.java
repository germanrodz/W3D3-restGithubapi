package com.blovvme.w3d3restfulandrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blovvme.w3d3restfulandrecyclerview.model.Grf;
import com.blovvme.w3d3restfulandrecyclerview.model.Repo;

import java.util.List;

/**
 * Created by Blovvme on 8/16/17.
 */

public class GrfRecyclerViewAdapter extends RecyclerView.Adapter<GrfRecyclerViewAdapter.ViewHolder> {

    private List<Repo> grfList;
    private  Context context;

    public GrfRecyclerViewAdapter(List<Repo> grfList) {
        this.grfList = grfList;
    }

    @Override
    public GrfRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);

        GrfRecyclerViewAdapter.ViewHolder viewHolder = new GrfRecyclerViewAdapter.ViewHolder(view);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = grfList.get(position);
        //holder.id.setText(repo.getId() + "" );
        holder.login.setText(repo.getName());


    }

    @Override
    public int getItemCount() {

        return grfList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView login;
        TextView id;

        public ViewHolder(View view) {
            super(view);
            login = (TextView) view.findViewById(R.id.login);
            //id = (TextView) view.findViewById(R.id.id);

        }
    }
}//
