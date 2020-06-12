package org.hueanalysis.moviediary.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.adapters.MovieAdapter;
import org.hueanalysis.moviediary.adapters.MovieItemClickListener;
import org.hueanalysis.moviediary.adapters.SliderPagerAdapter;
import org.hueanalysis.moviediary.models.Movie;
import org.hueanalysis.moviediary.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import static org.hueanalysis.moviediary.models.Movie.MOVIES;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<SlideModel> lstSlides;

    private ViewPager sliderpager;
    private TabLayout indicator;


    //메인 하단 인기 영화,드라마 리스트 리사이클 뷰 셋업

    private Movie[] movieData ;
    private RecyclerView movieRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);

        movieRV = findViewById(R.id.rv_movies);

        //메인 상단 상영중영화  slides 준비
        lstSlides = new ArrayList<>();
        lstSlides.add(new SlideModel(R.drawable.addastrada_bg, "애드 아스트라" ));
        lstSlides.add(new SlideModel(R.drawable.supersonic_bg, "수퍼 소닉" ));
        lstSlides.add(new SlideModel(R.drawable.parasite_bg, "기생충" ));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this.getBaseContext(), lstSlides);
        sliderpager.setAdapter(adapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);


        movieData = MOVIES;
        MovieAdapter movieAdapter = new MovieAdapter(this, movieData, this );

        movieRV.setAdapter(movieAdapter);
        //movieRV.setBackgroundColor(#);
        movieRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //movieRV.setLayoutManager(new GridLayoutManager(this, 3));

    }



    private long mLastClickTime  = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
            //movieImageView.setVisibility(View.VISIBLE);

//        //영화 정보를 영화 상세 페이지로 보낸다
//        //또한 두 activity 간의 트랜지션 애니메이션을 만든다.
//        Intent intent = new Intent(this, MovieDetailActivity.class);
//        intent.putExtra(MovieDetailActivity.EXTRA_PARAM_ID, Id);
//
////        //애니 메이션 처리
//        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                HomeActivity.this,
//                new Pair<>(HomeActivity.this.findViewById(R.id.item_movie_img),
//                        MovieDetailActivity.VIEW_NAME_MOVIE_IMAGE),
//                new Pair<>(HomeActivity.this.findViewById(R.id.item_movie_title),
//                        MovieDetailActivity.VIEW_NAME_MOVIE_TITLE)
//        );
//
//        ActivityCompat.startActivity(HomeActivity.this, intent, activityOptions.toBundle());



        Intent intent = new Intent(this, MovieDetailActivity.class);
        // send movie information to deatilActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getPoster_path());
        intent.putExtra("imgCover",movie.getBackdrop_path());
        intent.putExtra("overview",movie.getOverview());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                movieImageView,"sharedName");

      //  startActivity(intent, options.toBundle());
        startActivity(intent);


    }


    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(sliderpager.getCurrentItem() < lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}