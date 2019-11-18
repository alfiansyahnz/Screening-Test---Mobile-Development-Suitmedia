package com.example.suitmedia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.suitmedia.model.Guest;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {

    private ArrayList<Guest> isiGuest;
    private OnItemClickCallback onItemClickCallback;

    public GuestAdapter(ArrayList<Guest> isiGuest, OnItemClickCallback onItemClickCallback) {
        this.isiGuest = isiGuest;
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_guest, viewGroup, false);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GuestViewHolder holder, int i) {
        final Guest guest = isiGuest.get(i);
        Glide.with(holder.itemView.getContext())
                .load(isiGuest.get(i).getImageDummy())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.mImageViewGrid);
        holder.mTextViewGrid.setText(guest.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(isiGuest.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        if (isiGuest != null) {
            return isiGuest.size();
        } else {
            return 0;
        }
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_photo_grid)
        ImageView mImageViewGrid;

        @BindView(R.id.tv_nama_grid)
        TextView mTextViewGrid;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void logic(int birthdate) {
        int hasil = birthdate / 2;

        if (hasil % 2 == 0) {
            Toast.makeText(null, "Blackberry", Toast.LENGTH_SHORT).show();
        } else if (hasil % 3 == 0) {
            Toast.makeText(null, "Android", Toast.LENGTH_SHORT).show();
        } else if (hasil % 2 == 0 && hasil % 3 == 0) {
            Toast.makeText(null, "iOS", Toast.LENGTH_SHORT).show();
        }

    }
}
