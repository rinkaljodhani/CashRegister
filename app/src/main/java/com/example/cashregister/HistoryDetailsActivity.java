package com.example.cashregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cashregister.model.History;

import java.util.ArrayList;

public class HistoryDetailsActivity extends AppCompatActivity {

    TextView tv_name;
    TextView tv_amount;
    TextView tv_date;
    int position ;
    History history_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        findView();

    }

    private void findView() {

        position = getIntent().getIntExtra("position",0);

        history_data = ((MyApp)getApplication()).getHistoryList().get(position);
        tv_amount = findViewById(R.id.tv_amount);
        tv_name = findViewById(R.id.tv_name);
        tv_date = findViewById(R.id.tv_date);

        tv_name.setText("Product : "+history_data.getName());
        tv_amount.setText("Price : "+history_data.getPrice());
        tv_date.setText("Purchase Date : "+history_data.getDate());
    }
}