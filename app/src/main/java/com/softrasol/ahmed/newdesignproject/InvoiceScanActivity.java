package com.softrasol.ahmed.newdesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.softrasol.ahmed.newdesignproject.Adapters.DialogProductsAdapter;
import com.softrasol.ahmed.newdesignproject.Adapters.InvoiceAdapter;
import com.softrasol.ahmed.newdesignproject.Models.InVoiceModel;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class InvoiceScanActivity extends AppCompatActivity {

    SwitchCompat mBtnSwipe;
    private LinearLayout scanner, writeCode;

    private RecyclerView mRecyclerView, mRecyclerViewProducts;
    private InvoiceAdapter adapter;
    List<InVoiceModel> list = new ArrayList<>();

    InVoiceModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_scan);

        mRecyclerView = findViewById(R.id.recyclerView);
        mBtnSwipe = findViewById(R.id.btnSlide);

        scanner = findViewById(R.id.scanner);
        writeCode = findViewById(R.id.writeCode);

        mBtnSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mBtnSwipe.isChecked() == true){
                    writeCode.setVisibility(View.VISIBLE);
                    scanner.setVisibility(View.GONE);
                }else {
                    writeCode.setVisibility(View.GONE);
                    scanner.setVisibility(View.VISIBLE);

                }
            }
        });

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                final int position = viewHolder.getAdapterPosition();

                switch (direction)
                {
                    case ItemTouchHelper.LEFT:
                        model = list.get(position);
                        list.remove(position);
                        adapter.notifyItemRemoved(position);
                        Snackbar.make(mRecyclerView, "Undo", Snackbar.LENGTH_LONG)
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        list.add(position, model);
                                        adapter.notifyItemInserted(position);
                                    }
                                }).show();
                        break;
                }

            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addBackgroundColor(ContextCompat.getColor(InvoiceScanActivity.this, R.color.red_color))
                        .addActionIcon(R.drawable.ic_delete)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

// attaching the touch helper to recycler view
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);

        list.add(new InVoiceModel(18));
        list.add(new InVoiceModel(15));
        list.add(new InVoiceModel(43));
        list.add(new InVoiceModel(18));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new InvoiceAdapter(InvoiceScanActivity.this, list);
        mRecyclerView.setAdapter(adapter);

    }

    public void ButtonClick(View view) {

        BottomSheetDialog dialog = new BottomSheetDialog(InvoiceScanActivity.this);
        dialog.setContentView(R.layout.invoice_bottom_sheet);

        dialog.show();

        dialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);

    }

    public void ButonClick(View view) {
        startActivity(new Intent(getApplicationContext(), BillActivity.class));
    }
}