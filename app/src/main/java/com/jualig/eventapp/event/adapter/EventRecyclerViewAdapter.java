package com.jualig.eventapp.event.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jualig.datasource.persistence.network.response.EventResponse;
import com.jualig.eventapp.R;

import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventViewHolder> {

    private List<EventResponse> events;
    private int resource;
    private Activity activity;

    public EventRecyclerViewAdapter(List<EventResponse> events, int resource, Activity activity) {
        this.events = events;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventResponse event = this.events.get(position);
        Glide.with(activity)
                .load(event.getImage())
                //.apply(RequestOptions.circleCropTransform())
                .into(holder.menuImageView);
        holder.titleTextView.setText(event.getName());
        holder.descriptionTextView.setText(event.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        public ImageView menuImageView;
        public ImageView backgroundCategoryImageView;
        public RelativeLayout containerRelativeLayout;
        public TextView titleTextView;
        public TextView descriptionTextView;


        public EventViewHolder(View view) {
            super(view);
            backgroundCategoryImageView = view.findViewById(R.id.background_category_image_view);
            containerRelativeLayout = view.findViewById(R.id.container_relative_layout);
            menuImageView = view.findViewById(R.id.menu_image_view);
            titleTextView = view.findViewById(R.id.title_menu_text_view);
            descriptionTextView = view.findViewById(R.id.description_text_view);
        }
    }
}
