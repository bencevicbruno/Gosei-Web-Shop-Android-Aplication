package com.bb.goseiwebshop;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bb.goseiwebshop.product.Cache;

public class AboutActivity extends AppCompatActivity {

    private static final int DELAY = 15;

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_screen);

        logo = findViewById(R.id.logo_android);

        startLoop();
    }

    private void startLoop() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                while (!this.isInterrupted()) {
                    try {
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    logo.setRotation(logo.getRotation() + 1);
                }
            }
        };

        thread.start();
    }
}