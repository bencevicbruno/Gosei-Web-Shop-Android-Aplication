package com.bb.goseiwebshop;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bb.goseiwebshop.my_cart.MyCart;
import com.bb.goseiwebshop.product.Cache;
import com.bb.goseiwebshop.product.Product;
import com.squareup.picasso.Picasso;

import retrofit2.Call;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    private int productID;

    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;
    private TextView productDescription;
    private TextView[][] productDetails = new TextView[6][2];

    private Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_screen);

        this.productID = getIntent().getIntExtra("productID", 0);

        initialize();
        setup();
    }

    private void initialize() {
        productImage = findViewById(R.id.product_image);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.product_description);

        Resources res = getResources();
        int resID;

        for (int i = 0; i < 6; i++) {
            resID = res.getIdentifier("key" + (i + 1), "id", this.getPackageName());
            productDetails[i][0] = findViewById(resID);
            resID = res.getIdentifier("value" + (i + 1), "id", this.getPackageName());
            productDetails[i][1] = findViewById(resID);
        }

        addToCart = findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(this);
    }

    private void setup() {
        Product product = Cache.PRODUCTS.get(this.productID);

        Picasso.get().load(product.getImageurl()).placeholder(R.drawable.logo_circle).into(productImage);
        productName.setText(product.getName());
        productDescription.setText(product.getDescription());

        int i = 0;
        for (String key : product.getDetails().keySet()) {
            productDetails[i][0].setText(key);
            productDetails[i][1].setText(product.getDetails().get(key));
            i++;
        }

        productPrice.setText("Price: " + product.getPrice() + "$");
    }

    @Override
    public void onClick(View view) {
        if (view == addToCart) {
            MyCart.addToCart(this.productID, 1);
            Toast.makeText(this, this.productName.getText() + " " + this.getString(R.string.has_been_added_to_your_cart), Toast.LENGTH_LONG).show();
        }
    }
}