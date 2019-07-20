package com.example.ad36_nguyendanhhuy_day04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.Viewhoder> {
    List<Food> foodListCart;

    public AdapterCart(List<Food> foodListCart) {
        this.foodListCart = foodListCart;
    }

    @NonNull
    @Override
    public AdapterCart.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cost, parent, false);
        Viewhoder vh = new Viewhoder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCart.Viewhoder holder, int position) {
        Food food = foodListCart.get(position);

        holder.tvFoodNameCart.setText(food.getFoodname());
        holder.tvFoodCostCart.setText(String.valueOf(food.getFoodcost()));
    }

    @Override
    public int getItemCount() {
        return foodListCart.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvFoodNameCart, tvFoodCostCart;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);

            tvFoodNameCart = itemView.findViewById(R.id.tvFoodNameC);
            tvFoodCostCart = itemView.findViewById(R.id.tvFoodCostC);
        }
    }
}
