package com.example.app_ky.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.app_ky.R;

public class MVActivity extends AppCompatActivity {
    VideoView videoViewMp4;
    Toolbar toolbar_mv;
    TextView txt_content_mv;
    String uri;
    String name;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mv);

        initView();

        Intent intent = getIntent();
        uri = intent.getStringExtra("uri");
        name = intent.getStringExtra("name");
        content = intent.getStringExtra("content");


        setToolbar();
        setDataVideo();





    }

    private void setDataVideo() {
        videoViewMp4.setVideoURI(Uri.parse(uri));
        videoViewMp4.start();
        MediaController mediaController = new MediaController(MVActivity.this);
        // gán mediaController vào videoview
        mediaController.setMediaPlayer(videoViewMp4);
        videoViewMp4.setMediaController(mediaController);

        txt_content_mv.setText(content);
    }

    private void initView() {
        txt_content_mv = findViewById(R.id.txt_content_mv);
        toolbar_mv = findViewById(R.id.toolbar_mv);
        videoViewMp4 = findViewById(R.id.videoViewMp4);

    }

    private void setToolbar() {
        setSupportActionBar(toolbar_mv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_mv.setTitle(name);
        toolbar_mv.setNavigationIcon(R.drawable.arrowback2);
        toolbar_mv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
