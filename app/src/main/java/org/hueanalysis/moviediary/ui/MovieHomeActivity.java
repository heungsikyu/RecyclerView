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
import org.hueanalysis.moviediary.adapters.MovieAdapter;
import org.hueanalysis.moviediary.adapters.MovieItemClickListener;
import org.hueanalysis.moviediary.models.MovieModel;
import org.hueanalysis.moviediary.models.HomeSlideMovieModel;
import org.hueanalysis.moviediary.utils.DataSource;

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


public class MovieHomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<HomeSlideMovieModel> homeMoveSlide;
    private MovieModel[] popularMovieModels ;

    private ViewPager2 movieSliderPager;
    private LinearLayout indicatorLayout;
    private HomeSliderAdapter homeSliderAdapter;
    private RecyclerView homePopularMovieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_home);

        initViews();
        CompositePageTransformer compositePageTransformer = initResolutionSwipe();

        initMainSlider(compositePageTransformer);
        initPopularMovieList();

        //슬라이더 setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }

    //화면 초기화
    private void initViews() {
        movieSliderPager = findViewById(R.id.sliderPager); // 메인 슬라이더 페이져
        indicatorLayout = findViewById(R.id.layoutIndicators); //메인 슬라이더 인디케이
        homePopularMovieRV = findViewById(R.id.rv_popularmovies); //인기 영화
    }

    //메인 슬라이드 초기
    private void initMainSlider(CompositePageTransformer compositePageTransformer) {
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


    }

    //인기 영화 리스트
    private void initPopularMovieList() {
        //인기영화데이터 가져오기
        popularMovieModels = DataSource.getMOVIES();
        //인기 영화 리스트
        MovieAdapter movieAdapter = new MovieAdapter(this, popularMovieModels, this );

        homePopularMovieRV.setAdapter(movieAdapter);
        homePopularMovieRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //movieRV.setLayoutManager(new GridLayoutManager(this, 3));
    }

    //디바이스 해상도별 처리
    private CompositePageTransformer initResolutionSwipe() {
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
        return compositePageTransformer;
    }

    //메인 슬라이드 인디케이터 셋업
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
            indicatorLayout.addView(indicators[i]);
        }
    }

    //메인 슬라이드 인디케이터 초기화
    private void setCurrentMovieSliderIndicator(int index){
        int childCount = indicatorLayout.getChildCount();
        for(int i = 0; i <childCount; i++){
            ImageView imageView = (ImageView) indicatorLayout.getChildAt(i);
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

    //인기영화 클릭 이벤트 처리
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(MovieModel movie, ImageView movieImageView ) {

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
        intent.putExtra("streamimgLink",movie.getStreamimgLink());


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(movieImageView, "item_movie_transition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MovieHomeActivity.this, pairs);
        startActivity(intent, options.toBundle());

    }

    //메인 슬라이드 자동 슬라이딩 타이머 설정
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