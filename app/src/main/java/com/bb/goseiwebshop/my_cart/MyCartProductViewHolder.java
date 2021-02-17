package com.bb.goseiwebshop.my_cart;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.goseiwebshop.R;
import com.bb.goseiwebshop.product.Cache;
import com.bb.goseiwebshop.product.Product;
import com.squareup.picasso.Picasso;

public class MyCartProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private MyCartProductViewClickListener clickListener;

    private ImageView image;
    private TextView name;
    private TextView price;

    private Button buttonIncrease;
    private TextView quantityView;
    private Button buttonDecrease;

    private View parentView;
    private int productID;
    private int quantity;

    public MyCartProductViewHolder(@NonNull View itemView, MyCartProductViewClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
        init(itemView);

        this.parentView = itemView;
    }

    private void init(View view) {
        image = view.findViewById(R.id.product_card_image);
        name = view.findViewById(R.id.product_card_name);
        price = view.findViewById(R.id.product_card_price);

        buttonIncrease = view.findViewById(R.id.button_increase);
        buttonIncrease.setOnClickListener(this);
        quantityView = view.findViewById(R.id.product_quantity);
        buttonDecrease = view.findViewById(R.id.button_decrease);
        buttonDecrease.setOnClickListener(this);
    }

    public void setup(int productID, int quantity) {
        Product product = Cache.PRODUCTS.get(productID);

        Picasso.get().load(product.getImageurl()).placeholder(R.drawable.logo_circle).into(image);
        name.setText(product.getName());
        updateTotalPrice(Integer.parseInt(product.getPrice()));

        this.quantityView.setText(Integer.toString(quantity));

        this.productID = productID;
        this.quantity = quantity;

        updateTotalPrice(Integer.parseInt(product.getPrice()));

    }

    @Override
    public void onClick(View view) {
        if (view == buttonIncrease) {
            clickListener.onProductClick(this.productID, true);
            int oldQuantity = Integer.parseInt(this.quantityView.getText().toString());

            this.quantity = oldQuantity + 1;

            this.quantityView.setText(Integer.toString(oldQuantity + 1));
            updateTotalPrice(Integer.parseInt(Cache.PRODUCTS.get(this.productID).getPrice()));
        }

        else if (view == buttonDecrease) {
            clickListener.onProductClick(this.productID, false);
            int newQuantity = Integer.parseInt(this.quantityView.getText().toString());
            newQuantity = (newQuantity == 0) ? 0 : newQuantity - 1;

            this.quantity = newQuantity;
            this.quantityView.setText(Integer.toString(newQuantity));
            updateTotalPrice(Integer.parseInt(Cache.PRODUCTS.get(this.productID).getPrice()));
        }
    }

    private void updateTotalPrice(int productPrice) {
        price.setText(quantity + " x " + productPrice + "$ = " + (quantity * productPrice) + "$");
    }
}