package com.example.yuka;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuka.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DetailActivity extends YouTubeBaseActivity {

    ImageView ivBanner;
    TextView tvTitle;
    TextView tvOverview;
    TextView tvVenue;
    TextView tvTime;
    TextView tvOrganizer;

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivBanner = findViewById(R.id.ivBanner);
        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        tvVenue = findViewById(R.id.tvVenue);
        tvTime = findViewById(R.id.tvTime);
        tvOrganizer = findViewById(R.id.tvOrganizer);

        addMenuItemsFromJson();
    }

    private void addMenuItemsFromJson() {
        try {
            String jsonDataString = readJsonDataFromFile();
            JSONArray menuItemsJsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < menuItemsJsonArray.length(); ++i) {

                JSONObject menuItemObject = menuItemsJsonArray.getJSONObject(i);

                String menuItemName = menuItemObject.getString("name");
                String menuItemDescription = menuItemObject.getString("description");
                String menuItemPrice = menuItemObject.getString("price");
                String menuItemCategory = menuItemObject.getString("category");
                String menuItemImageName = menuItemObject.getString("photo");
                String menuItemTime = menuItemObject.getString("time");
                String menuItemDate = menuItemObject.getString("date");
                String menuItemLocation = menuItemObject.getString("location");
                String menuItemOrganizer = menuItemObject.getString("organizer");

                movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra("movie"));
                ivBanner.setImageDrawable(Drawable.createFromPath(movie.getImageName()));
                tvTitle.setText(movie.getName());
                tvOverview.setText(movie.getDescription());
                tvTime.setText(movie.getTime());
                tvOrganizer.setText(movie.getOrganizer());
                tvVenue.setText(movie.getVenue());
            }
        } catch (IOException | JSONException exception) {
            Log.e(MovieActivity.class.getName(), "Unable to parse JSON file.", exception);
        }
    }

    private String readJsonDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonDataString = null;
            inputStream = getResources().openRawResource(R.raw.locat);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null) {
                builder.append(jsonDataString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return new String(builder);
    }
}