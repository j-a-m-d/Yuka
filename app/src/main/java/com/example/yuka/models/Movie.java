package com.example.yuka.models;

import org.parceler.Parcel;

@Parcel
public class Movie {

    String name;
    String description;
    String price;
    String category;
    String imageName;
    String time;
    String venue;
    String organizer;
    String posterPath;

    int movieId;

    public Movie() {
    }

    public Movie(String name, String description, String price, String category,
                 String imageName, String time, String venue, String organizer, String posterPath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
        this.time = time;
        this.venue = venue;
        this.organizer = organizer;
        this.posterPath = posterPath;
    }


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImageName() {
        return imageName;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public String getOrganizer() {
        return organizer;
    }

}

