package com.example.cazzhit.UI.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.cazzhit.UI.adapters.RestaurantAdapter;
import com.example.cazzhit.datamodels.Restaurant;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView restaurantRV;
    RecyclerView.LayoutManager layoutManager;
    RestaurantAdapter adapter;
    ArrayList<Restaurant> arraylist;

    SharedPreferences sharedPreferences;

    private static final String SharedPrefs = "com.example.cazzhit.general_pref";
    private static final String VIEW_MODE = "VIEW_MODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restaurantRV=findViewById(R.id.places_rv);

        layoutManager = getLayoutManager(this,getSavedLayoutManager());
        //layoutManager=new LinearLayoutManager(this);
        adapter = new RestaurantAdapter(this,getData());
        adapter.setGridMode(getSavedLayoutManager());

        restaurantRV.setLayoutManager(layoutManager);
        restaurantRV.setAdapter(adapter);
    }
    private ArrayList<Restaurant> getData(){
        arraylist = new ArrayList<>();
        arraylist.add(new Restaurant("McDonald's","Via Tiburtina 251",8.50f,R.drawable.mc));
        arraylist.add(new Restaurant("Burger King","Via Tiburtina 351",12.50f,R.drawable.burger));
        arraylist.add(new Restaurant("KFC","Via Sandro Sandri 187", 15.00f,R.drawable.kfc));

        return arraylist;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.login_menu) {
            startActivity(new Intent(this, LoginActivity.class));
            return true;
        }
        else if (item.getItemId() ==R.id.checkout_menu){
            startActivity(new Intent(this, CheckoutActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.change_menu){
            setLayoutManager();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void setLayoutManager(){
        if(adapter.isGridMode()){
            layoutManager = new LinearLayoutManager(this);
        }else{
            layoutManager = new GridLayoutManager(this, 2);
        }

        adapter.setGridMode(!adapter.isGridMode());

        restaurantRV.setLayoutManager(layoutManager);
        restaurantRV.setAdapter(adapter);

        saveLayoutManager(adapter.isGridMode());
    }

    private RecyclerView.LayoutManager getLayoutManager(Context context, boolean isGridLayout){
        return isGridLayout ? new GridLayoutManager(context,2) : new LinearLayoutManager(context);
    }

    private void saveLayoutManager(boolean isGridMode){
        sharedPreferences = getSharedPreferences(SharedPrefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(VIEW_MODE, isGridMode);
        editor.apply();
    }

    private boolean getSavedLayoutManager (){
        sharedPreferences = getSharedPreferences(SharedPrefs, MODE_PRIVATE);
        return sharedPreferences.getBoolean(VIEW_MODE, false);

    }

}
