package com.example.cashregister.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashregister.HistoryDetailsActivity;
import com.example.cashregister.R;
import com.example.cashregister.model.History;
import com.example.cashregister.HistoryActivity;

import java.util.ArrayList;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder>{

    Activity activity;
    ArrayList<History> history_list;

    public RecyclerViewListAdapter(HistoryActivity historyActivity, ArrayList<History> history_list) {

        this.activity = historyActivity;
        this.history_list = history_list;

    }

    @NonNull
    @Override
    public RecyclerViewListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewListAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(history_list.get(position).getName());
        holder.tv_amount.setText(String.valueOf(history_list.get(position).getQty()));
        holder.tv_qty.setText(String.valueOf(history_list.get(position).getPrice()));

        holder.cv_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, HistoryDetailsActivity.class);
                intent.putExtra("mylist", history_list.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return history_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout cv_layout;
        public TextView tv_name;
        public TextView tv_amount;
        public TextView tv_qty;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_name =itemView.findViewById(R.id.tv_name);
            this.tv_amount =itemView.findViewById(R.id.tv_amount);
            this.tv_qty =itemView.findViewById(R.id.tv_qty);
            this.cv_layout =itemView.findViewById(R.id.cv_layout);
        }
    }

}
