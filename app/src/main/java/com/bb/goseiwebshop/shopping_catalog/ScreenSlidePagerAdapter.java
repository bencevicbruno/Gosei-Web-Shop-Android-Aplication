package com.bb.goseiwebshop.shopping_catalog;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bb.goseiwebshop.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int CATEGORIES_NUMBER = 5;

    private final ShoppingCatalogActivity activity;

    public ScreenSlidePagerAdapter(FragmentManager fm, ShoppingCatalogActivity activity) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {

        // slijedi odvratno hardcodean dio, Lord forgive me
        switch (position) {
            case 0: return ScreenSlidePageFragment.newInstance(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, this.activity);
            case 1: return ScreenSlidePageFragment.newInstance(new int[] {7, 8, 9, 10}, this.activity);
            case 2: return ScreenSlidePageFragment.newInstance(new int[] {1, 2, 3}, this.activity);
            case 3: return ScreenSlidePageFragment.newInstance(new int[] {11, 12, 13}, this.activity);
            case 4: return ScreenSlidePageFragment.newInstance(new int[] {4, 5, 6}, this.activity);
            default: throw new IllegalStateException("There should only be 5 fragments");
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0: return this.activity.getString(R.string.all_products);
            case 1: return this.activity.getString(R.string.vacuum_cleaners);
            case 2: return this.activity.getString(R.string.cameras);
            case 3: return this.activity.getString(R.string.smart_watches);
            case 4: return this.activity.getString(R.string.sensors);
            default: throw new IllegalArgumentException("There should only be 5 fragments!");
        }
    }

    @Override
    public int getCount() {
        return CATEGORIES_NUMBER;
    }
}