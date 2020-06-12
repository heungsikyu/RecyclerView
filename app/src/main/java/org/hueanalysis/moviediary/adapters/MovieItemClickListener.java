package org.hueanalysis.moviediary.adapters;

import android.widget.ImageView;

import org.hueanalysis.moviediary.models.Movie;


public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

}
