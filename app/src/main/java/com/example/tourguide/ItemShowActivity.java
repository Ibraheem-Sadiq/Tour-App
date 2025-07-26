package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemShowActivity extends AppCompatActivity {
 Intent intent;
 TextView textShow;
 ImageView imageShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_show);
        textShow =findViewById(R.id.ui_show_text);
        imageShow=findViewById(R.id.ui_show_image);
        intent =getIntent();
        if (intent !=null)
        {
            textShow.setText(intent.getStringExtra(ListFragment.TEXT_KEY));
            imageShow.setImageResource(intent.getIntExtra(ListFragment.IMaGE_ID_KEY,0));
        }
    }
}