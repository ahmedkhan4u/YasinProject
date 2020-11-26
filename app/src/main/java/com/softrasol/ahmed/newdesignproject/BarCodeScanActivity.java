package com.softrasol.ahmed.newdesignproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.softrasol.ahmed.newdesignproject.Fragments.ScanBarCodeFragment;


public class BarCodeScanActivity extends AppCompatActivity {

    SwitchCompat mBtnSlide;
    private RelativeLayout writeCodeLayout;
    private RelativeLayout scanCode;

    boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scan_libaray);

        setFragment(new ScanBarCodeFragment());
        writeCodeLayout = findViewById(R.id.layoutWriteCode);
        scanCode = findViewById(R.id.fragment);

        scanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InvoiceScanActivity.class));
            }
        });

        mBtnSlide = findViewById(R.id.btnSlide);

        mBtnSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mBtnSlide.isChecked() == true){
                    writeCodeLayout.setVisibility(View.VISIBLE);
                    scanCode.setVisibility(View.GONE);
                }else {
                    writeCodeLayout.setVisibility(View.GONE);
                    scanCode.setVisibility(View.VISIBLE);

                }
            }
        });


    }

    private void setFragment(ScanBarCodeFragment fragnent) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragnent);
        transaction.commit();

    }


}