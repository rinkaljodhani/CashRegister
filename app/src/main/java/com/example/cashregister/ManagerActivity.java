package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cashregister.model.History;
import com.example.cashregister.model.Product;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_history, btn_restock;
    ArrayList<History> historyArrayList;
    ArrayList<Product> remain_arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        findView();

    }

    private void findView() {

        remain_arraylist = new ArrayList<>();
        historyArrayList = new ArrayList<>();
        btn_history = findViewById(R.id.btn_history);
        btn_restock = findViewById(R.id.btn_restock);

        historyArrayList = (ArrayList<History>) getIntent().getSerializableExtra("mylist");
        remain_arraylist = (ArrayList<Product>) getIntent().getSerializableExtra("remain_list");

        btn_restock.setOnClickListener(this);
        btn_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_history:
                Intent intent = new Intent(ManagerActivity.this, HistoryActivity.class);
                intent.putExtra("mylist", historyArrayList);
                startActivity(intent);
                break;
            case R.id.btn_restock:
                Intent intentrestock = new Intent(ManagerActivity.this, RestockActivity.class);
                intentrestock.putExtra("remain_list", remain_arraylist);
                startActivity(intentrestock);
                break;
        }
    }
}