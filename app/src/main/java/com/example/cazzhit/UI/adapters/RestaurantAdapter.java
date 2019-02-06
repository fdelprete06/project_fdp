package com.example.cazzhit.UI.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cazzhit.datamodels.Restaurant;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private ArrayList<Restaurant> data;
    private boolean isGridMode;

    public boolean isGridMode() {
        return isGridMode;
    }

    public void setGridMode(boolean gridMode) {
        isGridMode = gridMode;
    }

    public RestaurantAdapter(Context context,ArrayList<Restaurant> data){
        inflater = LayoutInflater.from(context);
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layout;

        if(isGridMode){
            layout = R.layout.item_restaurant2;
        }
        else{
            layout = R.layout.item_restaurant;
        }
        View view=inflater.inflate(layout,viewGroup,false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RestaurantViewHolder vh = (RestaurantViewHolder) viewHolder;
        vh.restaurantName.setText(data.get(i).getNome());
        vh.restaurantAddress.setText(data.get(i).getIndirizzo());
        vh.restaurantPrice.setText(""+data.get(i).getPrezzoMedio());
        vh.restaurantImage.setImageResource(data.get(i).getImmagine());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{
        public TextView restaurantName;
        public TextView restaurantAddress;
        public TextView restaurantPrice;
        public ImageView restaurantImage;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.name_tv);
            restaurantAddress = itemView.findViewById(R.id.address_tv);
            restaurantPrice = itemView.findViewById(R.id.price_tv);
            restaurantImage=itemView.findViewById(R.id.restaurant_iv);
        }
    }

}
