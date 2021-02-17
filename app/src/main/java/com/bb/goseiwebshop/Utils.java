package com.bb.goseiwebshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

public class Utils {

    public static void switchActivity(Activity oldActivity, Class<? extends Activity> newActivityClass) {
        switchActivity(oldActivity, newActivityClass, false);
    }

    public static void switchActivity(Activity oldActivity, Class<? extends Activity> newActivityClass, boolean killOld) {
        Intent intent = new Intent(oldActivity, newActivityClass);

        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(oldActivity, android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
        oldActivity.startActivity(intent, bundle);

        if (killOld) oldActivity.finish();
    }

    public static void switchToProductActivity(Activity oldActivity, int productID) {
        Intent intent = new Intent(oldActivity, ProductActivity.class).putExtra("productID", productID);

        oldActivity.startActivity(intent);
    }
}