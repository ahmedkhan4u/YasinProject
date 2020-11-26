package com.softrasol.ahmed.newdesignproject.Adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.softrasol.ahmed.newdesignproject.InvoiceScanActivity;
import com.softrasol.ahmed.newdesignproject.Models.InVoiceModel;
import com.softrasol.ahmed.newdesignproject.R;

import java.util.List;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder> {

    Context context;
    private List<InVoiceModel> list;

    private int counter1 = 0, counter2=0;

    public InvoiceAdapter(Context context, List<InVoiceModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.invoice_items_list,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final InVoiceModel model = list.get(position);
        holder.mText.setText(model.getNum()+"");

        holder.mBtnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1(holder.mTxtAddSub1, true);
            }
        });

        holder.mBtnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1(holder.mTxtAddSub1, false);
            }
        });

        holder.mBtnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2(holder.mTxtAddSub2, true);
            }
        });

        holder.mBtnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2(holder.mTxtAddSub2, false);
            }
        });

        holder.mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setCancelable(true);

                View view1 = LayoutInflater.from(context).inflate
                        (R.layout.dialog_product_info, null);

                RecyclerView mRecyclerViewProducts = view1.findViewById(R.id.recyclerViewProducts);
                mRecyclerViewProducts.setLayoutManager(new LinearLayoutManager(context));
                DialogProductsAdapter adapter = new DialogProductsAdapter(context);
                mRecyclerViewProducts.setAdapter(adapter);

                builder1.setView(view1);



                AlertDialog alert11 = builder1.create();

                alert11.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


                alert11.show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void counter1(TextView holder, boolean b) {

        if (b==true){
            counter1++;
        }

        else if (b==false && counter1==0){
            return;
        }else {
            counter1--;
        }

        holder.setText(counter1+"\nحبة");
    }

    private void counter2(TextView holder, boolean b) {

        if (b==true){
            counter2++;
        }

        else if (b==false && counter2==0){
            return;
        }else {
            counter2--;
        }

        holder.setText(counter2+"\nحبة");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mText, mBtnAdd1, mBtnAdd2, mBtnSub1, mBtnSub2, mTxtAddSub1, mTxtAddSub2;
        private LinearLayout mShowDialog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mText = itemView.findViewById(R.id.number);
            mBtnAdd1 = itemView.findViewById(R.id.btnAdd1);
            mBtnAdd2 = itemView.findViewById(R.id.btnAdd2);
            mBtnSub1 = itemView.findViewById(R.id.btnSub1);
            mBtnSub2 = itemView.findViewById(R.id.btnSub2);
            mTxtAddSub1 = itemView.findViewById(R.id.txtAddSubText1);
            mTxtAddSub2 = itemView.findViewById(R.id.txtAddSubText2);
            mShowDialog = itemView.findViewById(R.id.lyoutShowDialog);

        }
    }
}
