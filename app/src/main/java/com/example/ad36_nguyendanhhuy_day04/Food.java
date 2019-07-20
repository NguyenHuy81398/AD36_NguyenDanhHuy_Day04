package com.example.ad36_nguyendanhhuy_day04;

import java.io.Serializable;

public class Food implements Serializable {
    String foodname;
    int foodcost;

    public Food(String foodname, int foodcost) {
        this.foodname = foodname;
        this.foodcost = foodcost;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodcost() {
        return foodcost;
    }

    public void setFoodcost(int foodcost) {
        this.foodcost = foodcost;
    }
}
