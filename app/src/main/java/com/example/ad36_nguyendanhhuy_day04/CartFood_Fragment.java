package com.example.ad36_nguyendanhhuy_day04;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartFood_Fragment extends Fragment {
    TextView tvTotal;
    Food foodCart1, foodCart2, foodCart3;
    List<Food> foodListCart;
    AdapterCart adapterCart;
    RecyclerView recyclerViewCart;

    public static CartFood_Fragment newInstance() {

        Bundle args = new Bundle();

        CartFood_Fragment fragment = new CartFood_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment, container, false);

        recyclerViewCart = view.findViewById(R.id.rvCartFood);
        tvTotal = view.findViewById(R.id.tvTotal);

        foodListCart = new ArrayList<>();
//        foodCart1 = new Food("AAAAAA", 20000);
//        foodCart2 = new Food("BBBBBB", 20000);
//
//        foodListCart.add(foodCart1);
//        foodListCart.add(foodCart2);
        Bundle bundle = getArguments();
        if(bundle != null){
            String foodname = bundle.getString("foodname");
            int foodcost = bundle.getInt("foodcost");
            foodListCart.add(new Food(foodname, foodcost));
        }

        adapterCart = new AdapterCart(foodListCart);
        recyclerViewCart.setAdapter(adapterCart);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCart.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
