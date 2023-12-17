package com.nursam.f55122052;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class Ecotrack extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            int photoResource = getIntent().getIntExtra("LINGKUNGAN_PHOTO", 0);
            String name = getIntent().getStringExtra("LINGKUNGAN_NAME");
            String description = getIntent().getStringExtra("LINGKUNGAN_DESCRIPTION");
            ImageView imageView = findViewById(R.id.img_item_photo);
            TextView nameTextView = findViewById(R.id.tv_item_name);
            TextView descriptionTextView = findViewById(R.id.tv_item_description);
            imageView.setImageResource(photoResource);
            nameTextView.setText(name);
            descriptionTextView.setText(description);
    }
}
