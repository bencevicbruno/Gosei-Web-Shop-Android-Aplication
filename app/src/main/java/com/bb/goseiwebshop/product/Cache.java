package com.bb.goseiwebshop.product;

import android.util.Log;

import com.bb.goseiwebshop.network.NetworkUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cache {
    public static final HashMap<Integer, Product> PRODUCTS = new HashMap<Integer, Product>();

    private static final String BASE_URL = "https://raw.githubusercontent.com/bencevicbruno/Gosei-Web-Shop-Database/main/product_";

    public static void init() {
        for (int i = 1; i <= 13; i++)
            downloadProduct(i);
    }

    public static boolean cacheInitialized() {
        return PRODUCTS.size() == 13;
    }

    private static void downloadProduct(int productID) {
        String urlPart = ((productID < 10) ? ("0" + productID) : productID) + ".json";
        Call<Product> apiCall = NetworkUtils.getApiInterface().getProduct(BASE_URL + urlPart);

        apiCall.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PRODUCTS.put(productID, response.body());
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.wtf("wtf", "didnt work");
                Log.wtf("reason", t.getMessage());
            }
        });
    }
}
