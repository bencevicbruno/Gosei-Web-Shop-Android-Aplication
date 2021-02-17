package com.bb.goseiwebshop.shopping_catalog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.goseiwebshop.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Integer> data = new ArrayList<Integer>();

    private ProductViewClickListener clickListener;

    public RecyclerAdapter(ProductViewClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        return new ProductViewHolder(cellView, this.clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.setup(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(int[] data) {
        this.data.clear();

        for (int i : data) this.data.add(i);

        notifyDataSetChanged();
    }
}
