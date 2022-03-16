package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class MovieListAdapter extends ArrayAdapter<MovieListModel> {
    Context context;
    String IMAGE_URL="https://image.tmdb.org/t/p/w500";

    public MovieListAdapter(@NonNull Context context, @NonNull List<MovieListModel> objects) {
        super(context,0, objects);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView=convertView;
        if(listView==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            listView=layoutInflater.inflate(R.layout.list_item, parent,false);
        }

        MovieListModel current=getItem(position);

        ImageView posterIV;
        TextView titleTV,overviewTV,voteTV,dateTV;

        posterIV=(ImageView) listView.findViewById(R.id.posterIV);
        String url=IMAGE_URL+current.getPoster_path();

        Glide.with(context)
                .load(url)
                .into(posterIV);

        titleTV=(TextView) listView.findViewById(R.id.titleTV);
        titleTV.setText(current.getOriginal_title());

        dateTV=(TextView) listView.findViewById(R.id.dateTV);
        dateTV.setText("release date : "+current.getRelease_date());

        voteTV=(TextView) listView.findViewById(R.id.voteTV);
        voteTV.setText("rating : "+current.getVote_average()+" ("+current.getVote_count()+")");

        overviewTV=(TextView) listView.findViewById(R.id.overviewTV);
        overviewTV.setText(current.getOverview());

        return listView;
    }
}
