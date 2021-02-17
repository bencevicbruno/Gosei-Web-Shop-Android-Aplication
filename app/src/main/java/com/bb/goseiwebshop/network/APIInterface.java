package com.bb.goseiwebshop.network;

import com.bb.goseiwebshop.product.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface {

    @GET
    Call<Product> getProduct(@Url String url);
}