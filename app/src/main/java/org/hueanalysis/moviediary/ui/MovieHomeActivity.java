package org.hueanalysis.moviediary.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.util.Pair;
import android.widget.LinearLayout;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.adapters.HomeSliderAdapter;
import org.hueanalysis.moviediary.adapters.PopularMovieAdapter;
import org.hueanalysis.moviediary.adapters.MovieItemClickListener;
import org.hueanalysis.moviediary.models.PopularMovieModel;
import org.hueanalysis.moviediary.models.HomeSlideMovieModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import static org.hueanalysis.moviediary.models.PopularMovieModel.MOVIES;

public class MovieHomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<HomeSlideMovieModel> homeMoveSlide;
    private ViewPager2 movieSliderPager;
    private LinearLayout layoutIndicator;
    private HomeSliderAdapter homeSliderAdapter;

    //메인 하단 인기 영화,드라마 리스트 리사이클 뷰 셋업
    private PopularMovieModel[] popularMovieModels ;
    private RecyclerView homePopularMovieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_home);

        movieSliderPager = findViewById(R.id.sliderPager); // 메인 슬라이더 페이져
        layoutIndicator = findViewById(R.id.layoutIndicators); //메인 슬라이더 인디케이
        homePopularMovieRV = findViewById(R.id.rv_popularmovies); //인기 영화


        //메인 상단 상영중영화  slides 준비
        homeMoveSlide = new ArrayList<>();
        homeMoveSlide.add(new HomeSlideMovieModel("애드 아스트라","/37M8j1nwMs8wu2H2tMtDjqhTSnd.jpg" ));
        homeMoveSlide.add(new HomeSlideMovieModel("수퍼 소닉","/pMXOlasWr1IzHGH8HWw1ZTXs6rQ.jpg" ));
        homeMoveSlide.add(new HomeSlideMovieModel("기생충" ,"/jKZYyrqeLt4wUzs8rE4tqRfDeCm.jpg"));
        homeMoveSlide.add(new HomeSlideMovieModel("블랙아웃 : 인베이젼 어스" ,"/2sWmX2mqhPOCEtFteX5pC7dZYPk.jpg"));
        homeMoveSlide.add(new HomeSlideMovieModel("스파이더맨: 파 프롬 홈" ,"/742vR63T1AcXzYwHypQpzZd89vh.jpg"));

        homeSliderAdapter = new HomeSliderAdapter(this, homeMoveSlide,movieSliderPager);
        movieSliderPager.setAdapter(homeSliderAdapter);

        movieSliderPager.setClipToPadding(false);
        movieSliderPager.setClipChildren(false);
        movieSliderPager.setOffscreenPageLimit(3);
        movieSliderPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        //해상도 별 Swipe 처리
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        if (height < 1777){
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.90f + r * 0.15f);
                }
            });
        }else{
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.75f + r * 0.15f);
                }
            });
        }

        movieSliderPager.setPageTransformer(compositePageTransformer);

        //setup indicator
        setupMovieSliderIndicators();
        setCurrentMovieSliderIndicator(0);
        movieSliderPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentMovieSliderIndicator(position);
            }
        });

        //슬라이더 setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);


        //인기영화데이터 가져오기
        popularMovieModels = MOVIES;
        //인기 영화 리스트
        PopularMovieAdapter movieAdapter = new PopularMovieAdapter(this, popularMovieModels, this );

        homePopularMovieRV.setAdapter(movieAdapter);
        homePopularMovieRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //movieRV.setLayoutManager(new GridLayoutManager(this, 3));

    }


    private void setupMovieSliderIndicators(){
        ImageView[] indicators = new ImageView[homeSliderAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0, 8,0);
        for(int i = 0 ; i < indicators.length; i++){
            indicators[i] = new ImageView((getApplicationContext()));
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentMovieSliderIndicator(int index){
        int childCount = layoutIndicator.getChildCount();
        for(int i = 0; i <childCount; i++){
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_active)
                );
            }else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_inactive)
                );
            }
        }
    }


    //인기 무비 클릭
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(PopularMovieModel movie, ImageView movieImageView ) {

        //영화 정보를 영화 상세 페이지로 보낸다
        //또한 두 activity 간의 트랜지션 애니메이션을 만든다.

        //애니 메이션 처리
        Intent intent = new Intent(this, MovieDetailActivity.class);
        // send movie information to deatilActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getPoster_path());
        intent.putExtra("imgCover",movie.getBackdrop_path());
        intent.putExtra("overview",movie.getOverview());
        intent.putExtra("voteRate",movie.getVote_average());


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(movieImageView, "item_movie_transition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MovieHomeActivity.this, pairs);
        startActivity(intent, options.toBundle());

    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            MovieHomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(movieSliderPager.getCurrentItem() < homeMoveSlide.size() - 1){
                        movieSliderPager.setCurrentItem(movieSliderPager.getCurrentItem()+1);
                    }
                    else
                        movieSliderPager.setCurrentItem(0);
                }
            });
        }
    }
}