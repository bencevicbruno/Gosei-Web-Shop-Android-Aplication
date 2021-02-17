package com.bb.goseiwebshop.my_cart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.goseiwebshop.R;
import com.bb.goseiwebshop.product.Cache;

public class MyCartActivity extends AppCompatActivity implements MyCartProductViewClickListener, View.OnClickListener{

    private RecyclerView recycler;
    private MyCartRecyclerAdapter adapter;

    private TextView textTotal;
    private Button buttonCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cart_screen);

        buttonCheckout = findViewById(R.id.button_checkout);
        buttonCheckout.setOnClickListener(this);
        textTotal = findViewById(R.id.total);

        setupRecycler();

        textTotal.setText("Total: " + this.getTotal() + "$");
    }

    private void setupRecycler() {
        recycler = findViewById(R.id.my_cart_recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyCartRecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onProductClick(int productID, boolean increaseQuantity) {
        if (increaseQuantity) MyCart.addToCart(productID, 1);
        else MyCart.removeFromCart(productID, 1);

        textTotal.setText("Total: " + this.getTotal() + "$");
    }

    @Override
    public void onClick(View v) {
        if (v == buttonCheckout) {
            Toast.makeText(this, "You've spent " + this.getTotal() + "$!", Toast.LENGTH_LONG).show();

            MyCart.CART.clear();
            adapter.notifyDataSetChanged();

            textTotal.setText("Total: " + this.getTotal() + "$");
        }
    }

    private int getTotal() {
        int total = 0;

        for (int id : MyCart.CART.keySet()) {
            int productPrice = Integer.parseInt(Cache.PRODUCTS.get(id).getPrice());

            total += productPrice * MyCart.CART.get(id);
        }

        return total;
    }
}