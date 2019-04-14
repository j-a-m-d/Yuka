package com.example.yuka;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.yuka.models.Location;
import com.example.yuka.adapters.LocationAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import butterknife.BindView;
import cz.msebera.android.httpclient.Header;

public class DetailActivity extends LocationActivity {

    public static final String YOUTUBE_API_KEY = "AIzaSyBZgL6maMjU4dHlJF7cGBheMP8_I4Ul7Fw";
    public static final String TRAILERS_API = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;

    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*ivlocationIcon = findViewById(R.id.ivLocationIcon)*/
        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        ratingBar = findViewById(R.id.ratingBar);

        location = (Location) Parcels.unwrap(getIntent().getParcelableExtra("location"));
        tvTitle.setText(location.getTitle());
        tvOverview.setText(location.getOverview());
        ratingBar.setRating((float) location.getVoteAverage());

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(TRAILERS_API, location.getLocationId()), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray results = response.getJSONArray("results");
                    if (results.length() == 0){
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }
}