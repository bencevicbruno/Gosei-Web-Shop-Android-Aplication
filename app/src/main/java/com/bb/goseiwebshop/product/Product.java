package com.bb.goseiwebshop.product;

import com.bb.goseiwebshop.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.HashMap;

public class Product {
    private String imageurl;
    private String name;
    private HashMap<String, String> details;
    private String description;
    private String price;

    public Product(String imageurl, String name, HashMap<String, String> details, String description, String price) {
        this.imageurl = imageurl;
        this.name = name;
        this.details = details;
        this.description = description;
        this.price = price;
    }

    public static Product copy(Product another) {
        HashMap<String, String> details = new HashMap<String, String>();
        details.putAll(another.details);

        return new Product(another.imageurl, another.name, details, another.description, another.price);
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getDetails() {
        return this.details;
    }

    public String getDescription() {
        return this.description.replace("<br>", "");
    }

    public String getPrice() {
        return this.price;
    }
}
