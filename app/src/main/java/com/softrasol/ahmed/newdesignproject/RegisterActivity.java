package com.softrasol.ahmed.newdesignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        view = findViewById(R.id.step1);
        view.setBackgroundResource(R.drawable.step_selected_bg);

    }

    public void ButonClick(View view) {
    }

    public void BarCodeScanClick(View view) {
    }

    public void InVoiceScanClick(View view) {
    }
}