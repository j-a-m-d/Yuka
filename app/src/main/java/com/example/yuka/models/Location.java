package com.example.yuka.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Location {

    double voteAverage;
    int locationId;
    String posterPath;
    String title;
    String overview;
    String backdropPath;

    public Location() {
    }

    public Location(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("original_title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
        voteAverage = jsonObject.getDouble("vote_average");
        locationId = jsonObject.getInt("id");
    }

    public static List<Location> fromJsonArray(JSONArray locationjsonArray) throws JSONException {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < locationjsonArray.length(); i++) {
            locations.add(new Location(locationjsonArray.getJSONObject(i)));
        }
        return locations;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);

    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getLocationId() {
        return locationId;
    }
}

