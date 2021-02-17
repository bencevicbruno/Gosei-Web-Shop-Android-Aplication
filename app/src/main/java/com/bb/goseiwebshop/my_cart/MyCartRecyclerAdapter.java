package com.bb.goseiwebshop.my_cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.goseiwebshop.R;

import java.util.ArrayList;
import java.util.List;

public class MyCartRecyclerAdapter extends RecyclerView.Adapter<MyCartProductViewHolder> {

    private final MyCartProductViewClickListener clickListener;

    public MyCartRecyclerAdapter(MyCartProductViewClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyCartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_cart_product_card, parent, false);

        return new MyCartProductViewHolder(view, this.clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartProductViewHolder viewHolder, int position) {
        int productID = new ArrayList<Integer>(MyCart.CART.keySet()).get(position);
        viewHolder.setup(productID, MyCart.getQuantity(productID));
    }

    @Override
    public int getItemCount() {
        return MyCart.CART.size();
    }
}
