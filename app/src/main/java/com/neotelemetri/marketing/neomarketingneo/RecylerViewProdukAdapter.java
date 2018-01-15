package com.neotelemetri.marketing.neomarketingneo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ACER on 1/14/2018.
 */

public class RecylerViewProdukAdapter extends RecyclerView.Adapter<RecylerViewProdukAdapter.DataObjectHolder> {

    private static String LOG_TAG = "RecyclerView";
    private ArrayList<DataObjectProduk> mDataSet;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt1;
        TextView txt2;

        public DataObjectHolder (View itemView) {
            super(itemView);
            txt1 = (TextView) itemView.findViewById(R.id.txt1);
            txt2 = (TextView) itemView.findViewById(R.id.txt2);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }
    public RecylerViewProdukAdapter(ArrayList<DataObjectProduk> myDataSet) {
        mDataSet = myDataSet;
    }

    public RecylerViewProdukAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_produk, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(RecylerViewProdukAdapter.DataObjectHolder holder, int position) {
        holder.txt1.setText(mDataSet.get(position).getmText1());
        holder.txt2.setText(mDataSet.get(position).getmText2());
    }

    public void addItem (DataObjectProduk dataObjectProduk, int index) {
        mDataSet.add(index, dataObjectProduk);
        notifyItemInserted(index);
    }

    public void deleteItem (int index) {
        mDataSet.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View view);
    }
}
