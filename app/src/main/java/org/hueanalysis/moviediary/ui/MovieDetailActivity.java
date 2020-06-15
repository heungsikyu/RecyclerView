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

import androidx.appcompat.app.AppCompatActivity;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description;
    private ExpandableTextView expandableTextView ;
    private CircularProgressIndicator circularProgress;

    private FloatingActionButton play_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Window w = getWindow();
       // w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // ini views
        iniViews();


    }

    void iniViews() {
        play_fab = findViewById(R.id.play_fab);

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

        //MovieThumbnailImg.setImageResource(imageResourceId);

        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this)
                .asBitmap()
                .load(imagecover)
                .into(MovieCoverImg);

        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
//        getSupportActionBar().setTitle(movieTitle);



//        tv_description = findViewById(R.id.detail_movie_desc);
//        tv_description.setText(overview);

        expandableTextView = findViewById(R.id.detail_movie_desc);
        expandableTextView.setText(overview);


        circularProgress = findViewById(R.id.vote_rate);
        circularProgress.setMaxProgress(100);
        circularProgress.setCurrentProgress(voteRate*10);


        // setup animation
        MovieThumbnailImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }
}