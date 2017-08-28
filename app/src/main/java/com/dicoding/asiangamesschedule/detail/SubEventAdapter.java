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

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
        holder.textArena.setText(data.get(position).getArenas().get(0).getName());

        Timestamp startStamp = new Timestamp(Long.parseLong(data.get(position).getStartTime()));
        Timestamp endStamp = new Timestamp(Long.parseLong(data.get(position).getEndTime()));
        Date startDate = new Date(startStamp.getTime());
        Date endDate = new Date(endStamp.getTime());
        SimpleDateFormat formatDate = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm");
        holder.textTime.setText(formatDate.format(startDate) + " - " + formatDate.format(endDate));

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
