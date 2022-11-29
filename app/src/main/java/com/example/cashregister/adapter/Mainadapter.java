package com.example.cashregister.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cashregister.model.Product;
import com.example.cashregister.R;

import java.util.ArrayList;

public class Mainadapter extends BaseAdapter {

    Context context;
    ArrayList<Product> product_array;

    public Mainadapter(Activity mainActivity, ArrayList<Product> product_array) {
        this.context = mainActivity;
        this.product_array = product_array;
    }

    @Override
    public int getCount() {
        return product_array.size();
    }

    @Override
    public Object getItem(int position) {
        return product_array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.row_list, parent, false);
        }

        // get the TextView for item name and item description
        TextView tv_name = (TextView)
                convertView.findViewById(R.id.tv_name);
        TextView tv_amount = (TextView)
                convertView.findViewById(R.id.tv_amount);
        TextView tv_qty = (TextView)
                convertView.findViewById(R.id.tv_qty);

        //sets the text for item name and item description from the current item object
        tv_name.setText(product_array.get(position).getName());
        tv_amount.setText(String.valueOf(product_array.get(position).getPrice()));
        tv_qty.setText(String.valueOf(product_array.get(position).getQty()));

        // returns the view for the current row
        return convertView;

    }
}
