package com.example.suitmedia.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.suitmedia.model.Event;
import com.example.suitmedia.EventGuestActivity;
import com.example.suitmedia.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private ArrayList<Event> isievent;

    public EventAdapter(ArrayList<Event> isi) {
        this.isievent = isi;
    }

    @NonNull
    @Override

    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_event, viewGroup, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewHolder holder, int i) {
        final Event event = isievent.get(i);
        Glide.with(holder.itemView.getContext())
                .load(event.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.mImageView);
        holder.mTextViewName.setText(event.getNama());
        holder.mTextViewDate.setText(event.getTanggal());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, EventGuestActivity.class);
                i.putExtra("nameEvent", event.getNama());
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (isievent != null) {
            return isievent.size();
        } else {
            return 0;
        }
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_image)
        ImageView mImageView;

        @BindView(R.id.item_name)
        TextView mTextViewName;

        @BindView(R.id.item_date)
        TextView mTextViewDate;

        @BindView(R.id.card_view_event)
        CardView mCardView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
