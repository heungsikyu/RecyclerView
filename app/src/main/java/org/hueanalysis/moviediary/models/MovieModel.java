package org.hueanalysis.moviediary.models;

import org.hueanalysis.moviediary.utils.DataSource;

import java.util.ArrayList;
import java.util.List;

public class MovieModel {


    private double popularity;
    private int vote_count;
    private boolean video;
    private String poster_path;

    private int id;
    private boolean adult;
    private String backdrop_path;
    private String original_language ;
    private String original_title;

    private String title;
    private double vote_average;
    private String overview;
    private String release_date;

    private String streamimgLink;


    private ArrayList<Genre> genre;
    private int budget;
    private String homepage;
    private int revenue;



    private static final String POSTER_THUMB_BASE_URL = "https://image.tmdb.org/t/p/w440_and_h660_face";
    private static final String BACKGROUND_BASE_URL = "https://image.tmdb.org/t/p/w500_and_h282_face";


    public MovieModel(int id, String title, double vote_average, String streamimgLink, String original_title, String poster_path, String backdrop_path, String overview) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.vote_average = vote_average;
        this.streamimgLink = streamimgLink;
    }


    public static MovieModel getMovie(int mId){
        for (MovieModel movie : DataSource.getMOVIES()){
            if(movie.getMovieId() == mId){
                return movie;
            }
        }
        return null;
    }

    private int getMovieId() {
        return this.id;
    }


    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return POSTER_THUMB_BASE_URL + poster_path;
    }

    public String getBackdrop_path() {
        return BACKGROUND_BASE_URL + backdrop_path;
    }

    public double getVote_average() {
        return this.vote_average;
    }

    public String getStreamimgLink() {
        return streamimgLink;
    }

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public int size(){
        return DataSource.getMOVIES().length;
    }


}
