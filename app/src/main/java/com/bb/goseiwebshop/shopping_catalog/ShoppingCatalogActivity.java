package com.bb.goseiwebshop.shopping_catalog;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bb.goseiwebshop.R;
import com.bb.goseiwebshop.Utils;
import com.google.android.material.tabs.TabLayout;

public class ShoppingCatalogActivity extends AppCompatActivity implements ProductViewClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_catalog);

        init();
        setupPager();
    }

    private void init() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab);
    }

    private void setupPager() {
        PagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onProductClick(int productID) {
        Utils.switchToProductActivity(this, productID);
    }
}