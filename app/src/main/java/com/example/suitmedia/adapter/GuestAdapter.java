package com.example.suitmedia.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.suitmedia.EventGuestActivity;
import com.example.suitmedia.R;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.model.Guest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {
    private List<Guest> mGuestArrayList;
    private ArrayList<Event> mEventArrayList;

    public GuestAdapter(List<Guest> guestArrayList, ArrayList<Event> eventArrayList) {
        this.mGuestArrayList = guestArrayList;
        this.mEventArrayList = eventArrayList;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_guest, viewGroup, false);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GuestViewHolder holder, int i) {
        final Guest guest = mGuestArrayList.get(i);
        holder.mTextView.setText(guest.getName());

        switch (guest.getName()) {
            case "Andi":
                holder.mImageView.setBackgroundResource(R.drawable.concert);
                break;
            case "Budi":
                holder.mImageView.setBackgroundResource(R.drawable.livemusic);
                break;
            case "Charlie":
                holder.mImageView.setBackgroundResource(R.drawable.cocktails);
                break;
            case "Dede":
                holder.mImageView.setBackgroundResource(R.drawable.fairground);
                break;
            case "Joko":
                holder.mImageView.setBackgroundResource(R.drawable.concert2);
                break;
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, EventGuestActivity.class);
                i.putExtra("nameGuest", guest.getName());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGuestArrayList.size();
    }

    class GuestViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item_photo_grid)
        ImageView mImageView;
        @BindView(R.id.tv_nama_grid)
        TextView mTextView;

        GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
