package com.softrasol.ahmed.newdesignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void ButonClick(View view) {
        startActivity(new Intent(getApplicationContext(), AuthActivity.class));
    }

    public void GotoRegisterClick(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    public void GotoBarCodeClick(View view) {
        startActivity(new Intent(getApplicationContext(), BarCodeScanActivity.class));
    }
}