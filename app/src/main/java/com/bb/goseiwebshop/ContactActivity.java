package com.bb.goseiwebshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonMail, buttonPhone, buttonLocation;
    ImageView imageFB, imageTW, imageIG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_screen);

        init();
    }

    private void init() {
        buttonMail = findViewById(R.id.button_mail);
        buttonMail.setOnClickListener(this);
        buttonPhone = findViewById(R.id.button_phone);
        buttonPhone.setOnClickListener(this);
        buttonLocation = findViewById(R.id.button_location);
        buttonLocation.setOnClickListener(this);

        imageFB = findViewById(R.id.image_fb);
        imageFB.setOnClickListener(this);
        imageTW = findViewById(R.id.image_tw);
        imageTW.setOnClickListener(this);
        imageIG = findViewById(R.id.image_ig);
        imageIG.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) {
            Toast.makeText(this, "Not implemented!", Toast.LENGTH_SHORT).show();
        }
        else if (v == buttonMail) openMail();
        else if (v == buttonPhone) openCall();
        else if (v == buttonLocation) openMaps();
    }

    private void openMail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(("mailto:contact@gosei.com")));
        startActivity(intent);
    }

    private void openCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+123 45 56 789"));

        startActivity(intent);
    }

    private void openMaps() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/xDwaKc6oYUN9WYBK7"));
        startActivity(intent);
    }
}