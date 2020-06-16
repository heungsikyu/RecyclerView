package org.hueanalysis.moviediary.adapters;

import android.widget.ImageView;

import org.hueanalysis.moviediary.models.MovieModel;


public interface MovieItemClickListener {

    void onMovieClick(MovieModel movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

}
