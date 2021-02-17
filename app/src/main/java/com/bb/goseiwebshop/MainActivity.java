package com.bb.goseiwebshop;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bb.goseiwebshop.product.Cache;

public class MainActivity extends AppCompatActivity {

    private static final int DELAY = 15;

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        Cache.init();

        logo = findViewById(R.id.logo);

        startLoop();
    }

    private void startLoop() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                while (!this.isInterrupted() && !Cache.cacheInitialized()) {
                    try {
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    logo.setRotation(logo.getRotation() + 1);
                }

                Utils.switchActivity(MainActivity.this, NavigationActivity.class, true);
            }
        };

        thread.start();
    }
}