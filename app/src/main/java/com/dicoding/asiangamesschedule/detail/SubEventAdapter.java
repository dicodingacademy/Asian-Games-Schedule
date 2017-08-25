package com.dicoding.asiangamesschedule.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dicoding.asiangamesschedule.R;
import com.dicoding.asiangamesschedule.model.EventResponse;
import com.dicoding.asiangamesschedule.model.SubEvent;

import java.util.ArrayList;
import java.util.List;

public class SubEventAdapter extends RecyclerView.Adapter<SubEventAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<SubEvent> data;
    private Context context;

    public SubEventAdapter(Context context, List<SubEvent> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public SubEventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_event_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubEventAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.textEventName.setText(data.get(position).getName());
        holder.textTime.setText(data.get(position).getStartTime() + " - " + data.get(position).getEndTime());
        holder.textArena.setText(data.get(position).getArenas().get(0).getName());

        Object images = data.get(position).getImageUrl();
        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.imageEvent);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {
        void onClick(SubEvent Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textEventName;
        TextView textTime;
        TextView textArena;
        ImageView imageEvent;

        public ViewHolder(View itemView) {
            super(itemView);
            textEventName = itemView.findViewById(R.id.event_name);
            textTime = itemView.findViewById(R.id.time);
            textArena = itemView.findViewById(R.id.arena);
            imageEvent = itemView.findViewById(R.id.event_image);

        }

        public void click(final SubEvent subEventData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(subEventData);
                }
            });
        }
    }
}
