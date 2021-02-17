package com.bb.goseiwebshop;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bb.goseiwebshop.my_cart.MyCartActivity;
import com.bb.goseiwebshop.shopping_catalog.ShoppingCatalogActivity;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    private View myCart;
    private View shoppingCatalog;
    private View contact;
    private View about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_screen);

        init();
    }

    private void init() {
        myCart = findViewById(R.id.navigation_my_cart);
        myCart.setOnClickListener(this);
        shoppingCatalog = findViewById(R.id.navigation_shopping_catalog);
        shoppingCatalog.setOnClickListener(this);
        contact = findViewById(R.id.navigation_contact);
        contact.setOnClickListener(this);
        about = findViewById(R.id.navigation_about);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == myCart) Utils.switchActivity(this, MyCartActivity.class);
        else if (view == shoppingCatalog) Utils.switchActivity(this, ShoppingCatalogActivity.class);
        else if (view == contact) Utils.switchActivity(this, ContactActivity.class);
        else if (view == about) Utils.switchActivity(this, AboutActivity.class);
    }
}