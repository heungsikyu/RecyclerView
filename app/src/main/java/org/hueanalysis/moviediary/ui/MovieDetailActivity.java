package org.hueanalysis.moviediary.ui;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.hueanalysis.moviediary.R;
import org.hueanalysis.moviediary.adapters.MovieCastAdapter;
import org.hueanalysis.moviediary.models.CastMovieModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

import static org.hueanalysis.moviediary.models.CastMovieModel.CASTS;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description;
    private ExpandableTextView expandableTextView ;
    private CircularProgressIndicator circularProgress;

    private FloatingActionButton play_fab;

    private RecyclerView rvMovieCast;
    private CastMovieModel[] castMovieModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        initViews();

    }

    void initViews() {
        play_fab = findViewById(R.id.play_fab);
        rvMovieCast = findViewById(R.id.rv_moviecast);

        String movieTitle = getIntent().getExtras().getString("title");
        String imagethumUrl = getIntent().getExtras().getString("imgURL");
        String imagecover = getIntent().getExtras().getString("imgCover");
        String overview = getIntent().getExtras().getString("overview");
        double voteRate = getIntent().getExtras().getDouble("voteRate");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this)
                .asBitmap()
                .load(imagethumUrl)
                .into(MovieThumbnailImg);


        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this)
                .asBitmap()
                .load(imagecover)
                .into(MovieCoverImg);

        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);

        expandableTextView = findViewById(R.id.detail_movie_desc);
        expandableTextView.setText(overview);

        circularProgress = findViewById(R.id.vote_rate);
        circularProgress.setMaxProgress(100);
        circularProgress.setCurrentProgress(voteRate*10);
        circularProgress.setProgressTextAdapter(TIME_TEXT_ADAPTER);

        // setup animation
        MovieThumbnailImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));


        //영화 등장인물
        castMovieModels = CASTS;
        MovieCastAdapter movieCastAdapter = new MovieCastAdapter(this, castMovieModels);
        rvMovieCast.setAdapter(movieCastAdapter);
        rvMovieCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }

    private static final CircularProgressIndicator.ProgressTextAdapter TIME_TEXT_ADAPTER = new CircularProgressIndicator.ProgressTextAdapter() {
        @Override
        public String formatText(double voteRate) {
            String vr = String.valueOf(voteRate/10);
            return vr;
        }
    };
}