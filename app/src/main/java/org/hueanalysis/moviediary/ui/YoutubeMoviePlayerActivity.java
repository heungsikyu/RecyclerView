package org.hueanalysis.moviediary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kr.co.prnd.YouTubePlayerView;
import kr.co.prnd.YouTubePlayerView.OnInitializedListener;


import org.hueanalysis.moviediary.R;

public  class YoutubeMoviePlayerActivity extends AppCompatActivity  {

    private YouTubePlayerView youTubePlayerView;
    private OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_movie_player);


        String videoId = getIntent().getExtras().getString("streamimgLink");


        youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.play(videoId, listener);
    }

}