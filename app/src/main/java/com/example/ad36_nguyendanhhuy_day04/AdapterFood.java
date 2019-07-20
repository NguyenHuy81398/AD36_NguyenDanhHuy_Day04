package com.example.ad36_nguyendanhhuy_day04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.Viewhorder> {
    List<Food> foodList;
    IOnClickFood iOnClickFood;

    public void setiOnClickFood(IOnClickFood iOnClickFood) {
        this.iOnClickFood = iOnClickFood;
    }

    public AdapterFood(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public Viewhorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_food, parent, false);
        AdapterFood.Viewhorder vh = new Viewhorder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhorder holder, int position) {
        final Food food = foodList.get(position);

        holder.tvFoodName.setText(food.getFoodname());
        holder.tvFoodCost.setText(String.valueOf(food.getFoodcost()));

        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnClickFood.onClickFood(food.getFoodname(), food.getFoodcost());
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class Viewhorder extends RecyclerView.ViewHolder {
        TextView tvFoodName, tvFoodCost;
        LinearLayout ItemList;
        public Viewhorder(@NonNull View itemView) {
            super(itemView);
            ItemList = itemView.findViewById(R.id.ItemList);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
            tvFoodCost = itemView.findViewById(R.id.tvFoodCost);
        }
    }
}
