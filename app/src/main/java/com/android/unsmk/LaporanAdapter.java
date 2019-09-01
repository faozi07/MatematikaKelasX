package com.android.unsmk;

/*
 * Created by faozi on 01/02/18.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class LaporanAdapter extends RecyclerView.Adapter {

    public static Activity activity;
    public static ArrayList<modelPenjualan> items;
    modelPenjualan mrt;

    private final int VIEW_ITEM = 1;
    private int lastPosition = -1;

    private AlertDialog.Builder dialogs;
    private AlertDialog dialogListDetail;

    LaporanAdapter(Activity act, ArrayList<modelPenjualan> data) {
        activity = act;
        items = data;
        dialogs = new AlertDialog.Builder(activity);
        dialogListDetail = dialogs.create();
    }

    @Override
    public int getItemViewType(int position) {
        int VIEW_PROG = 0;
        return items.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public static class BrandViewHolder extends RecyclerView.ViewHolder {

        TextView tSupplier, tNamaBrg, tJml, tTotal;
        RecyclerView rvLaporan;
        CardView cardView;

        BrandViewHolder(View v) {
            super(v);

            tSupplier = v.findViewById(R.id.teksSupplier);
            tNamaBrg = v.findViewById(R.id.teksNamaBrg);
            tJml = v.findViewById(R.id.teksJml);
            tTotal = v.findViewById(R.id.teksTotal);
            cardView = v.findViewById(R.id.card_view);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder vh = null;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_list_laporan, parent, false);

            vh = new LaporanAdapter.BrandViewHolder(v);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (holder instanceof LaporanAdapter.BrandViewHolder) {

            mrt = items.get(position);
            ((BrandViewHolder) holder).tSupplier.setText(mrt.getSupplier());

            ((BrandViewHolder) holder).tNamaBrg.setText(mrt.getNamaBrg());
            ((BrandViewHolder) holder).tJml.setText(mrt.getJml());
            ((BrandViewHolder) holder).tTotal.setText(mrt.getTotal());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
