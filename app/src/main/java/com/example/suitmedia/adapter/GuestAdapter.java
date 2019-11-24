package com.example.suitmedia.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.suitmedia.R;
import com.example.suitmedia.callback.OnItemClickCallback;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.model.Guest;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {
    private ArrayList<Guest> mGuestArrayList;
    private ArrayList<Event> mEventArrayList;
    private OnItemClickCallback mOnItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.mOnItemClickCallback= onItemClickCallback;
    }

    public GuestAdapter(ArrayList<Guest> guestArrayList, ArrayList<Event> eventArrayList) {
        mGuestArrayList = guestArrayList;
        mEventArrayList = eventArrayList;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_guest, viewGroup, false);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GuestViewHolder holder, int i) {
        Guest guest = mGuestArrayList.get(i);
        Event event = mEventArrayList.get(i);
        Glide.with(holder.itemView.getContext())
                .load(event.getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.mImageView);
        holder.mTextView.setText(guest.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickCallback.onItemClicked(mGuestArrayList.get(holder.getAdapterPosition()));
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
