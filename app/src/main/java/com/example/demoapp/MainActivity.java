package com.example.demoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String API_KEY="bea96c9674fb335184669cf9d4efa3a3";
    String POPULAR_URL="https://api.themoviedb.org/3/movie/popular?api_key="+API_KEY+"&language=en-US&page=1";
    String UPCOMING_URL="https://api.themoviedb.org/3/movie/upcoming?api_key="+API_KEY+"&language=en-US&page=1";
    String TOP_RATED_URL="https://api.themoviedb.org/3/movie/top_rated?api_key="+API_KEY+"&language=en-US&page=1";
    String NOW_PLAYING_URL="https://api.themoviedb.org/3/movie/now_playing?api_key="+API_KEY+"&language=en-US&page=1";
    //        String LATEST_URL="https://api.themoviedb.org/3/movie/latest?api_key="+API_KEY+"&language=en-US";
    String TRENDING_URL="https://api.themoviedb.org/3/trending/all/day?api_key="+API_KEY;



    List<MovieListModel> movieListModelArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



//        https://api.themoviedb.org/3/movie/trending?api_key=bea96c9674fb335184669cf9d4efa3a3&language=en-US

        Button popularBtn, upcomingBtn, topRatedBtn, nowPlayingBtn;
         popularBtn=(Button) findViewById(R.id.popularBtn);
         upcomingBtn=(Button) findViewById(R.id.upcomingBtn);
         topRatedBtn=(Button) findViewById(R.id.topRatedBtn);
         nowPlayingBtn=(Button)findViewById(R.id.nowPlayingBtn);
//         latestBtn=(Button)findViewById(R.id.latestBtn);

        Intent popularIntent=new Intent(MainActivity.this,PopularActivity.class);
        MySingleton mySingleton=MySingleton.getInstance(MainActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, TRENDING_URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                                textView.setText(response.toString());


                           fetchTrending(response);
                            RecyclerView trendingRV = (RecyclerView) findViewById(R.id.trendingRV);
                            TrendingAdapter trendingAdapter = new TrendingAdapter(MainActivity.this, (ArrayList<MovieListModel>) movieListModelArrayList);
                            trendingRV.setAdapter(trendingAdapter);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                            trendingRV.setLayoutManager(linearLayoutManager);
//                        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,2);
//                        trendingRV.setLayoutManager(gridLayoutManager);


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        mySingleton.addToRequestQueue(jsonObjectRequest);



        popularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, POPULAR_URL, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                textView.setText(response.toString());
                                popularIntent.putExtra("response", response.toString());
                                startActivity(popularIntent);
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });
                mySingleton.addToRequestQueue(jsonObjectRequest);
            }
        });

        upcomingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent popularIntent=new Intent(MainActivity.this,PopularActivity.class);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, UPCOMING_URL, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                textView.setText("harsh"+response.toString());
                                popularIntent.putExtra("response", response.toString());
                                startActivity(popularIntent);
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });
                mySingleton.addToRequestQueue(jsonObjectRequest);
            }
        });

        topRatedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent popularIntent=new Intent(MainActivity.this,PopularActivity.class);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, TOP_RATED_URL, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                textView.setText("harsh"+response.toString());
                                popularIntent.putExtra("response", response.toString());
                                startActivity(popularIntent);
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });
                mySingleton.addToRequestQueue(jsonObjectRequest);
            }
        });

        nowPlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent popularIntent=new Intent(MainActivity.this,PopularActivity.class);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, NOW_PLAYING_URL, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                textView.setText("harsh"+response.toString());
                                popularIntent.putExtra("response", response.toString());
                                startActivity(popularIntent);
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });
                mySingleton.addToRequestQueue(jsonObjectRequest);
            }
        });

//        latestBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                Intent popularIntent=new Intent(MainActivity.this,PopularActivity.class);
//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                        (Request.Method.GET, LATEST_URL, null, new Response.Listener<JSONObject>() {
//
//                            @Override
//                            public void onResponse(JSONObject response) {
////                                textView.setText("harsh"+response.toString());
//                                popularIntent.putExtra("response", response.toString());
//                                startActivity(popularIntent);
//                            }
//                        }, new Response.ErrorListener() {
//
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                // TODO: Handle error
//
//                            }
//                        });
//                mySingleton.addToRequestQueue(jsonObjectRequest);
//            }
//        });


    }
    public void fetchTrending(JSONObject response)
    {
        try {
        JSONArray resultList = response.getJSONArray("results");
//                textView.setText(resultList.toString());

        for (int i = 0; i < resultList.length(); i++) {
            MovieListModel movieListModel = new MovieListModel();
            JSONObject result_ith = resultList.getJSONObject(i);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}