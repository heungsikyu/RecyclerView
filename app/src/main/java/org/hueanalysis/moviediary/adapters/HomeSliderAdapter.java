package org.hueanalysis.moviediary.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.models.SlideModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class HomeSliderAdapter  extends RecyclerView.Adapter<HomeSliderAdapter.HomeSliderViewHolder> {

    Context context;
    private List<SlideModel> slideMovieList;
    private ViewPager2 viewPager2;

    public HomeSliderAdapter(Context context, List<SlideModel> slideMovieList, ViewPager2 viewPager2) {
        this.context = context;
        this.slideMovieList = slideMovieList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public HomeSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      return new HomeSliderViewHolder(
              LayoutInflater.from(parent.getContext()).inflate(
                      R.layout.home_movie_slide,
                      parent,
                      false)
      );
    }

    @Override
    public void onBindViewHolder(@NonNull HomeSliderViewHolder holder, int position) {
        //holder.setImage(slideMovieList.get(position));
        Glide.with(context)
                //.asBitmap()
                .load(slideMovieList.get(position).getPoster_path())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return slideMovieList.size();
    }



    class HomeSliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        public HomeSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.homeMovieSlide);
        }

        void setImage(SlideModel movieList) {
           // imageView.setImageResource(movieList.getImage());
            Glide.with(context)
                    //.asBitmap()
                    .load(movieList.getPoster_path())
                    .into(imageView);
        }


    }
}
