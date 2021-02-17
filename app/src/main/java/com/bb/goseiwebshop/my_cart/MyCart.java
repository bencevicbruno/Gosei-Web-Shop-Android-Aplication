package com.bb.goseiwebshop.my_cart;

import androidx.appcompat.app.AppCompatActivity;

import com.bb.goseiwebshop.product.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MyCart {
    public static LinkedHashMap<Integer, Integer> CART = new LinkedHashMap<>();

    public static void addToCart(int productID, int quantity) {
        if (CART.containsKey(productID))
            CART.put(productID, CART.get(productID) + quantity);
        else
            CART.put(productID, 1);
    }

    public static int getQuantity(int productID) {
        return CART.get(productID);
    }

    public static void removeFromCart(int productID, int quantity) {
        if (CART.containsKey(productID)) {
            CART.put(productID, CART.get(productID) - quantity);

            if (CART.get(productID) <= 0) {
                CART.remove(productID);
            }
        }
    }
}