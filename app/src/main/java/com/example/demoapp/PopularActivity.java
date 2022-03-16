package com.example.demoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PopularActivity extends AppCompatActivity {

    ListView listView;
    String POSTER_URL="https://image.tmdb.org/t/p/original/wwemzKWzjKYJFfCeiB57q3r4Bcm.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_action_bar);
        ImageView actionBarIV=(ImageView)findViewById(R.id.actionBarIV);
        Glide.with(PopularActivity.this)
                .load(POSTER_URL)
                .into(actionBarIV);

        List<MovieListModel> movieListModelArrayList=new ArrayList<>();
//        TextView textView=(TextView) findViewById(R.id.jsonTV);

        try {
            JSONObject jsonObj = new JSONObject(getIntent().getStringExtra("response"));
            JSONArray resultList=jsonObj.getJSONArray("results");
//                textView.setText(resultList.toString());

                for(int i=0;i<resultList.length();i++)
                {
                    MovieListModel movieListModel=new MovieListModel();
                    JSONObject result_ith=resultList.getJSONObject(i);
                    movieListModel.setBackdrop_path(result_ith.getString("backdrop_path"));
                    movieListModel.setId(result_ith.getLong("id"));
                    movieListModel.setOriginal_title(result_ith.getString("original_title"));
                    movieListModel.setOverview(result_ith.getString("overview"));
                    movieListModel.setPopularity(result_ith.getDouble("popularity"));
                    movieListModel.setPoster_path(result_ith.getString("poster_path"));
                    movieListModel.setRelease_date(result_ith.getString("release_date"));
                    movieListModel.setTitle(result_ith.getString("title"));
                    movieListModel.setVideo(result_ith.getBoolean("video"));
                    movieListModel.setVote_average(result_ith.getDouble("vote_average"));
                    movieListModel.setVote_count(result_ith.getLong("vote_count"));

                    movieListModelArrayList.add(movieListModel);
                }
            listView=(ListView)findViewById(R.id.popularLV);
            MovieListAdapter arrayAdapter =new MovieListAdapter(this,movieListModelArrayList);
            listView.setAdapter(arrayAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}