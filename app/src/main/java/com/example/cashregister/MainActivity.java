package com.example.cashregister;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.SplashScreen;

import com.example.cashregister.adapter.Mainadapter;
import com.example.cashregister.model.History;
import com.example.cashregister.model.Product;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_product_type, tv_quantity, tv_total;
    Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine, btn_zero, btn_clear, btn_buy,btn_manager;
    String display_quantity = "";
    ListView lv_list;
    int selected_position = -1;
    ArrayList<Product> product_array;
    ArrayList<History> history_product_array;
    Mainadapter mainadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

    }

    private void findView() {

        product_array = new ArrayList<>();
        history_product_array = new ArrayList<>();
        tv_product_type = findViewById(R.id.tv_product_type);
        tv_total = findViewById(R.id.tv_total);
        tv_quantity = findViewById(R.id.tv_quantity);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_zero = findViewById(R.id.btn_zero);
        btn_clear = findViewById(R.id.btn_clear);
        btn_buy = findViewById(R.id.btn_buy);
        btn_manager = findViewById(R.id.btn_manager);
        lv_list = findViewById(R.id.lv_list);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_buy.setOnClickListener(this);
        btn_manager.setOnClickListener(this);

        if(getIntent().getExtras()!=null){

            Toast.makeText(MainActivity.this, "HIIIIIIIIIIIIII product", Toast.LENGTH_LONG).show();

            product_array = (ArrayList<Product>) getIntent().getSerializableExtra("remain_data");

        }else {

            Product p1 = new Product("Pants", 20.44, 10);
            Product p2 = new Product("Shoes", 10.44, 100);
            Product p3 = new Product("Hats", 5.9, 30);


            product_array.add(p1);
            product_array.add(p2);
            product_array.add(p3);


        }



        mainadapter = new Mainadapter(MainActivity.this, product_array);
        lv_list.setAdapter((ListAdapter) mainadapter);
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_product_type.setText(product_array.get(position).getName());
                selected_position = position;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                display_quantity = display_quantity + "1";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_two:
                display_quantity = display_quantity + "2";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_three:
                display_quantity = display_quantity + "3";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_four:
                display_quantity = display_quantity + "4";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_five:
                display_quantity = display_quantity + "5";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_six:
                display_quantity = display_quantity + "6";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_seven:
                display_quantity = display_quantity + "7";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_eight:
                display_quantity = display_quantity + "8";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_nine:
                display_quantity = display_quantity + "9";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_zero:
                display_quantity = display_quantity + "0";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_clear:
                display_quantity = "";
                tv_quantity.setText(display_quantity);
                break;
            case R.id.btn_buy:
                if (selected_position == -1) {
                    Toast.makeText(MainActivity.this, "Please select Product", Toast.LENGTH_LONG).show();
                } else {
                    if (display_quantity.equals("")) {
                        Toast.makeText(MainActivity.this, "Please enter quantity", Toast.LENGTH_LONG).show();
                    } else {
                        if (Integer.parseInt(display_quantity) > product_array.get(selected_position).getQty()) {
                            Toast.makeText(MainActivity.this, "OUT OF STOCK", Toast.LENGTH_LONG).show();
                        } else {
                            double total_amount = Integer.parseInt(display_quantity) * product_array.get(selected_position).getPrice();
                            tv_total.setText(String.valueOf(total_amount));
                            int remain_qty = product_array.get(selected_position).getQty() - Integer.parseInt(display_quantity);
                            product_array.get(selected_position).setQty(remain_qty);
                            mainadapter.notifyDataSetChanged();

                            History h1 = new History(product_array.get(selected_position).getName(),total_amount,Integer.valueOf(display_quantity),new Date().toString());
                            history_product_array.add(h1);
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Thank you for your Purchase")
                                    .setMessage("Your Purchase is " + display_quantity + " " + product_array.get(selected_position).getName() + " for " + total_amount)
                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                    .setCancelable(true)
                                    .show();
                        }
                    }
                }
                break;
            case R.id.btn_manager:
                Intent intent = new Intent(MainActivity.this,ManagerActivity.class);
                intent.putExtra("mylist", history_product_array);
                intent.putExtra("remain_list", product_array);
                startActivity(intent);
                break;
        }
    }
}