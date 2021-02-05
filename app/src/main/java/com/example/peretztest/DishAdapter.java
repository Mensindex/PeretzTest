package com.example.peretztest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {
    private final List<Dish> dishes;

    DishAdapter(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @NonNull
    public DishAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.dish_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(dishes.get(position));
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView dishView, minusView, plusView;
        final TextView dishName, dishRecipe, price, number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dishView = (ImageView) itemView.findViewById(R.id.imageViewDish);
            minusView = (ImageView) itemView.findViewById(R.id.imageViewMinus);
            plusView = (ImageView) itemView.findViewById(R.id.imageViewPlus);
            dishName = (TextView) itemView.findViewById(R.id.textViewDishName);
            dishRecipe = (TextView) itemView.findViewById(R.id.textViewDishRecipe);
            price = (TextView) itemView.findViewById(R.id.textViewPrice);
            number = (TextView) itemView.findViewById(R.id.textViewNumber);
        }

        private void bind(Dish dish) {

            Glide.with(itemView.getContext())
                    .load(dish.image)
                    .into(dishView);

            dishName.setText(dish.getName());
            dishRecipe.setText(dish.getDescription());
            price.setText(String.valueOf(dish.getPrice()));
        }
    }
}
