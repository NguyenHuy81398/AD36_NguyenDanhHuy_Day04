package com.example.ad36_nguyendanhhuy_day04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFood_Fragment.Data {
    private static final String TAG = "MainActivity";
    ListFood_Fragment.Data data;
    TextView tvSoluong;
    TextView tvTotal;
    Button btnOrder;
    RelativeLayout btnCart;
    BottomNavigationView navigationView;
    TextView tvUsername;
    ListFood_Fragment listFood_fragment;
    CartFood_Fragment cartFood_fragment;
    int i=0, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav);
        tvUsername = findViewById(R.id.tvUsername);
        btnOrder = findViewById(R.id.btnOrder);
        tvSoluong = findViewById(R.id.tvSoluong);
        tvTotal = findViewById(R.id.tvTotal);
        btnCart = findViewById(R.id.btnCartMain);

        Intent intentLogin = getIntent();
        String user = intentLogin.getStringExtra("username");
        tvUsername.setText(user);

        listFood_fragment = new ListFood_Fragment();
        cartFood_fragment = new CartFood_Fragment();
        getFragment(listFood_fragment);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.mnList){
                    getFragment(listFood_fragment);
                }
                if(menuItem.getItemId() == R.id.mnCart){
                    getFragment(cartFood_fragment);
                }
                return false;
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragment(cartFood_fragment);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());

            }
        });
    }

    public void getFragment(Fragment fragment){
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "getFragment: "+ e.getMessage());
        }
    }

    @Override
    public void senData(String foodname, int foodcost) {
        cartFood_fragment = new CartFood_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("foodname", foodname);
        bundle.putInt("foodcost", foodcost);
        cartFood_fragment.setArguments(bundle);
        i++;
        tvSoluong.setText(String.valueOf(i));
        total = total + foodcost;
        tvTotal.setText("Total: "+ total+" VNĐ");
    }
}
