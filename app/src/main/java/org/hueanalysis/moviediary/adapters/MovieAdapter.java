package org.hueanalysis.moviediary.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.models.Movie;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    Movie[] movies ;

    MovieItemClickListener movieItemClickListener;

    RequestOptions option;

    public MovieAdapter(Context context, Movie[] movies, MovieItemClickListener listener) {
        this.context = context;
        this.movies = movies;
        movieItemClickListener = listener;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_movie_detail, parent, false);

        final MovieViewHolder viewHolder = new MovieViewHolder(view) ;

        //영화 정보 클릭
        viewHolder.containerMovie.setOnClickListener(new View.OnClickListener() {
            int i = 0 ;
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 1) {
                           // Toast.makeText(context, movies[viewHolder.getAdapterPosition()].getTitle() + " " + movies[viewHolder.getAdapterPosition()], Toast.LENGTH_SHORT).show();
                            movieItemClickListener.onMovieClick(movies[viewHolder.getAdapterPosition()], viewHolder.ImgMovieView);
                        } else if (i == 2) {
                            //  Toast.makeText(context, "더블 클릭", Toast.LENGTH_SHORT).show();
                        }
                        i = 0;
                    }
                },500);

            }
        });


        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {


        holder.TvTitle.setText(movies[position].getTitle());

        Glide.with(context)
                //.asBitmap()
                .load(movies[position].getPoster_path())
                //.diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(option)
                .into(holder.ImgMovieView);

    }

    @Override
    public int getItemCount() {
        return movies.length;
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private TextView TvTitle ;
        private ImageView ImgMovieView;
        private ConstraintLayout containerMovie;


        public MovieViewHolder(@NonNull final View itemView) {
            super(itemView);

            containerMovie = itemView.findViewById(R.id.detail_movie_container);
            ImgMovieView = itemView.findViewById(R.id.item_movie_img);
            TvTitle = itemView.findViewById(R.id.item_movie_title);


        }

        @Override
        public String toString() {
            return super.toString();
        }
    }




}
