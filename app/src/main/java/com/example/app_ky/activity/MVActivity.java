package com.example.app_ky.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.app_ky.R;

public class MVActivity extends AppCompatActivity {
    VideoView videoViewMp4;
    Toolbar toolbar_mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mv);

        setToolbar();

        Intent intent = getIntent();
        String ok = intent.getStringExtra("uri");

        Log.e("urii", "onCreate: " +  ok);

        videoViewMp4 = findViewById(R.id.videoViewMp4);

        videoViewMp4.setVideoURI(Uri.parse(ok));
        videoViewMp4.start();

        MediaController mediaController = new MediaController(MVActivity.this);
        // gán mediaController vào videoview
        mediaController.setMediaPlayer(videoViewMp4);
        videoViewMp4.setMediaController(mediaController);

    }

    private void setToolbar() {
        toolbar_mv = findViewById(R.id.toolbar_mv);
        setSupportActionBar(toolbar_mv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_mv.setNavigationIcon(R.drawable.ic_notifications_black_24dp);
        toolbar_mv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
