package com.bb.goseiwebshop.shopping_catalog;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.goseiwebshop.R;
import com.bb.goseiwebshop.Utils;
import com.bb.goseiwebshop.product.Cache;
import com.bb.goseiwebshop.product.Product;
import com.squareup.picasso.Picasso;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ProductViewClickListener clickListener;

    private ImageView image;
    private TextView name;
    private TextView price;

    private int productID;

    public ProductViewHolder(@NonNull View itemView, ProductViewClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
        init(itemView);
    }

    private void init(View view) {
        image = view.findViewById(R.id.product_card_image);
        name = view.findViewById(R.id.product_card_name);
        price = view.findViewById(R.id.product_card_price);
    }

    public void setup(int productID) {
        Product product = Cache.PRODUCTS.get(productID);

        Picasso.get().load(product.getImageurl()).placeholder(R.drawable.logo_circle).into(image);
        name.setText(product.getName());
        price.setText(product.getPrice() + "$");

        this.productID = productID;
    }

    @Override
    public void onClick(View view) {
        clickListener.onProductClick(this.productID);
    }
}
