package com.softrasol.ahmed.newdesignproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;
import com.softrasol.ahmed.newdesignproject.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanBarCodeFragment extends Fragment implements ZXingScannerView.ResultHandler {


    public ScanBarCodeFragment() {
        // Required empty public constructor
    }

    private View mView;
    private ZXingScannerView mScannerView;
    private String TAG = "dxdiag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_scan_bar_code, container, false);

        mScannerView = new ZXingScannerView(getActivity());   // Programmatically initialize the scanner view


        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v(TAG, rawResult.getText()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }
}