package com.example.cashregister;

import android.app.Application;

import com.example.cashregister.model.History;
import com.example.cashregister.model.Product;

import java.util.ArrayList;

public class MyApp extends Application {

    private ArrayList<Product> product_array;
    private ArrayList<History> history_array = new ArrayList<>();


    public ArrayList<Product> getList(){
        if (product_array == null) {
            product_array = new ArrayList<>();
        }

        return product_array;
    }

    public void addNewToDO(Product toadd){
        product_array.add(toadd);
    }

    public ArrayList<History> getHistoryList() {
        if (history_array == null) {
            history_array = new ArrayList<>();
        }

        return history_array;
    }


    public void addNewHistoryToDO(History toadd) {
        history_array.add(toadd);
    }
}
