package org.hueanalysis.moviediary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.models.CastingModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieCastAdapter extends RecyclerView.Adapter<MovieCastAdapter.MovieCastViewHolder> {

    Context mContext;
    CastingModel[] casts ;

    public MovieCastAdapter(Context mContext, CastingModel[] casts){
        this.mContext = mContext;
        this.casts = casts;
    }


    @NonNull
    @Override
    public MovieCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieCastViewHolder movieCastViewHolder = new MovieCastViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_movie_cast,
                parent,
                false)
        );
        return movieCastViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCastViewHolder holder, int position) {
        String profile_path = casts[position].getProfile_path();
        Glide.with(mContext)
                .load(profile_path)
                .into(holder.castImageView);
    }

    @Override
    public int getItemCount() {
        return casts.length;
    }

    public class MovieCastViewHolder extends RecyclerView.ViewHolder {
        private ImageView castImageView;
        public MovieCastViewHolder(@NonNull View itemView) {
            super(itemView);

            castImageView = itemView.findViewById(R.id.item_movie_cast);

        }
    }

}
