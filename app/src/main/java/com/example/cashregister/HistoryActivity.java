package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.cashregister.adapter.RecyclerViewListAdapter;
import com.example.cashregister.model.History;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rv_list;
    RecyclerViewListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Log.e("TAG", "oncreate: ::::::::::::::::::::::" );

        findView();
    }

    private void findView() {
        rv_list = findViewById(R.id.rv_list);


        adapter = new RecyclerViewListAdapter(HistoryActivity.this,((MyApp)getApplication()).getHistoryList());
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(adapter);



    }

    @Override
    protected void onResume() {
        Log.e("TAG", "onResume: ::::::::::::::::::::::" );
        super.onResume();
    }
}