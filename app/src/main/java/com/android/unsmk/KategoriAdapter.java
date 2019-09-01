package com.android.unsmk;

/*
 * Created by faozi on 01/02/18.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class KategoriAdapter extends RecyclerView.Adapter {

    public static Activity activity;
    public static ArrayList<String> items;

    private final int VIEW_ITEM = 1;
    private int lastPosition = -1;

    KategoriAdapter(Activity act, ArrayList<String> data) {
        activity = act;
        items = data;
    }

    @Override
    public int getItemViewType(int position) {
        int VIEW_PROG = 0;
        return items.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public static class BrandViewHolder extends RecyclerView.ViewHolder {

        TextView teksKategori;
        CardView cardView;

        BrandViewHolder(View v) {
            super(v);

            teksKategori = v.findViewById(R.id.teksKategori);
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
                    R.layout.item_list_kategori, parent, false);

            vh = new KategoriAdapter.BrandViewHolder(v);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (holder instanceof KategoriAdapter.BrandViewHolder) {

            ((BrandViewHolder) holder).teksKategori.setText(items.get(position));

            ((BrandViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    mrt = items.get(position);
                    SoundBtn.soundBtn(activity);
//                    dialogListDetail(mrt.getTglInput(), mrt.getMerek(), mrt.getNopol(), mrt. getTglJanji(), mrt.getJnsKerja());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
