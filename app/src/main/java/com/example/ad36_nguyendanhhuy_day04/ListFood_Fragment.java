package com.example.ad36_nguyendanhhuy_day04;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFood_Fragment extends Fragment {
    Data data;
    Button btnOrder;
    RecyclerView recyclerView;
    Food food1, food2, food3, food4, food5, food6;
    List<Food> foodList;
    AdapterFood adapterFood;
    int i=0;

    public interface Data{
        void senData(String foodname, int foodcost);
    }

    public static ListFood_Fragment newInstance() {

        Bundle args = new Bundle();

        ListFood_Fragment fragment = new ListFood_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listfood_fragment, container, false);

        recyclerView = view.findViewById(R.id.rvListFood);
        btnOrder = view.findViewById(R.id.btnOrder);

        foodList = new ArrayList<>();
        food1 = new Food("Gà rán", 50000);
        food2 = new Food("Hambeger", 30000);
        food3 = new Food("Khoai tây", 25000);
        food4 = new Food("Coca cola", 18000);
        food5 = new Food("Pepsi", 18000);
        food6 = new Food("Gà chiên", 60000);

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);

        adapterFood = new AdapterFood(foodList);
        recyclerView.setAdapter(adapterFood);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapterFood.setiOnClickFood(new IOnClickFood() {
            @Override
            public void onClickFood(String foodname, int foodcost) {

                data.senData(foodname, foodcost);
                Toast.makeText(getContext(), "Thêm thành công "+foodname+".", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Data){
             data = (Data) context;
        }else{
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        data = null;
    }
}
