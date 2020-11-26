package com.softrasol.ahmed.newdesignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout1, layout2, layout3, layout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);

    }

    public void ButonClick(View view) {

        int id = view.getId();

        if (id == R.id.layout1){
            setBackgroundGrey();
            layout1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        if (id == R.id.layout2){
            setBackgroundGrey();
            layout2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        if (id == R.id.layout3){
            setBackgroundGrey();
            layout3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        if (id == R.id.layout4){
            setBackgroundGrey();
            //layout4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            layout4.setBackgroundResource(R.drawable.bottom_round_light);
        }

    }

    private void setBackgroundGrey() {

        layout1.setBackgroundColor(Color.parseColor("#E8E8E8"));
        layout2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        layout3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        //layout4.setBackgroundColor(Color.parseColor("#E8E8E8"));
        layout4.setBackgroundResource(R.drawable.bottom_corners_round_bg);


    }

    public void NewActivityClick(View view) {
        startActivity(new Intent(getApplicationContext(), BarCodeScanActivity.class));
    }
}