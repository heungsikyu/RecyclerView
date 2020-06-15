package org.hueanalysis.moviediary.models;

public class HomeSlideMovieModel {

    private int Image;
    private String Title;
    private String Poster_path;
    private static final String POSTER_THUMB_BASE_URL = "https://image.tmdb.org/t/p/w440_and_h660_face";
    private static final String BACKGROUND_BASE_URL = "https://image.tmdb.org/t/p/w500_and_h282_face";

    public HomeSlideMovieModel(String title, String poster_path) {
        Title = title;
        Poster_path = poster_path;
    }

    public String getPoster_path() {
        return POSTER_THUMB_BASE_URL + Poster_path;
    }

    public void setPoster_path(String poster_path) {
        Poster_path = poster_path;
    }

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
