package com.softrasol.ahmed.newdesignproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }

    public void ButonClick(View view) {

        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

    }
}