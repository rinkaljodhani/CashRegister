package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cashregister.adapter.Mainadapter;
import com.example.cashregister.model.Product;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_qty;
    ListView lv_list;
    Button btn_ok,btn_cancel;
    int selected_position = -1;
    Mainadapter mainadapter;
    ArrayList<Product> remain_arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        findView();
    }

    private void findView() {

        remain_arraylist = new ArrayList<>();

        remain_arraylist = (ArrayList<Product>) getIntent().getSerializableExtra("remain_list");

        et_qty = findViewById(R.id.et_qty);
        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        lv_list = findViewById(R.id.lv_list);

        btn_ok.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

        mainadapter = new Mainadapter(RestockActivity.this, remain_arraylist);
        lv_list.setAdapter((ListAdapter) mainadapter);

        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_position = position;


            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                if(et_qty.getText().toString().equals("")){
                    Toast.makeText(RestockActivity.this,"enter quantity",Toast.LENGTH_LONG).show();
                }else{
                    if(selected_position == -1 ) {
                        Toast.makeText(RestockActivity.this, "selectany product", Toast.LENGTH_LONG).show();
                    }else{
                        int total_qty = remain_arraylist.get(selected_position).getQty()+Integer.parseInt(et_qty.getText().toString());
                        remain_arraylist.get(selected_position).setQty(total_qty);
                        mainadapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.btn_cancel:
                et_qty.setText("");
                Intent intentrestock = new Intent(RestockActivity.this, MainActivity.class);
                intentrestock.putExtra("remain_data",remain_arraylist);
                startActivity(intentrestock);
                break;

        }
    }
}