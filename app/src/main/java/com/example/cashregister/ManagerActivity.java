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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        findView();

    }

    private void findView() {


        btn_history = findViewById(R.id.btn_history);
        btn_restock = findViewById(R.id.btn_restock);

        btn_restock.setOnClickListener(this);
        btn_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_history:
                Intent intent = new Intent(ManagerActivity.this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_restock:
                Intent intentrestock = new Intent(ManagerActivity.this, RestockActivity.class);
                startActivity(intentrestock);
                break;
        }
    }
}