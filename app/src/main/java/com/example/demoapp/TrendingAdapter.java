package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    ArrayList<MovieListModel> trendingAdapterArrayList;
    Context context;
    String IMAGE_URL="https://image.tmdb.org/t/p/w500";

    public TrendingAdapter(Context context,ArrayList<MovieListModel>trendingAdapterArrayList) {
        this.context=context;
        this.trendingAdapterArrayList=trendingAdapterArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem= layoutInflater.inflate(R.layout.trending_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieListModel currentModel=trendingAdapterArrayList.get(position);

        String url=IMAGE_URL+currentModel.getPoster_path();
        Glide.with(context)
                .load(url)
                .into(holder.trendingIV);
        holder.trendingTV.setText(currentModel.getOriginal_title());
    }

    @Override
    public int getItemCount() {
        return trendingAdapterArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView trendingIV;
        public TextView trendingTV;

        public ViewHolder(View itemView) {
            super(itemView);
            this.trendingIV = (ImageView) itemView.findViewById(R.id.trendingIV);
            this.trendingTV = (TextView) itemView.findViewById(R.id.trendingTV);
        }
    }
}
