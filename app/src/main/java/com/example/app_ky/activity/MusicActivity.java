package com.example.app_ky.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.app_ky.R;
import com.example.app_ky.model.MusicData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {
    TextView  txtTimeSong, txtTimeTotal,txt_music_detail,txt_single_detail,txt_lyric;
    SeekBar skSong;
    ImageButton btnPrev, btnPlay, btnStop, btnNext;
    ImageView imgHinh;
    Toolbar toolbar_music;
    CircleImageView imageViewDisc;

    String mp3,title,single,ava,lyric;
    int poss;
//    int position = 0;

    MediaPlayer mediaPlayer;
    Animation animation;
    ArrayList<MusicData> musicData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        Intent intent = getIntent();
        mp3 = intent.getStringExtra("music");
        title = intent.getStringExtra("title");
        single = intent.getStringExtra("single");
        ava = intent.getStringExtra("ava");
        lyric = intent.getStringExtra("lyric");
        poss = intent.getIntExtra("pos",0);

        Bundle bundle = intent.getBundleExtra("BUNDLE");
        musicData = (ArrayList<MusicData>) bundle.getSerializable("ARRAYLIST");



        animation = AnimationUtils.loadAnimation(this, R.anim.disc_rotate);


        Log.e("mang", "onCreate: " + musicData.size() );

        Log.e("mang", "ava: " + ava );

        initView();
        setToolBar();
        setDataMp3();
        CreateMediaPlayer();
        ActionEventMedia();


    }

    private void ActionEventMedia() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setVisibility(View.VISIBLE);

                } else {
                    mediaPlayer.start();
                    btnStop.setVisibility(View.VISIBLE);
                    btnPlay.setVisibility(View.GONE);
                }

                SetTimeTotal();
                UpdateTimeSong();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.GONE);
                CreateMediaPlayer();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poss--;
                if (poss < 0){
                    poss = musicData.size() - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                CreateMediaPlayer();
                mediaPlayer.start();
                btnPlay.setVisibility(View.GONE);
                btnStop.setVisibility(View.VISIBLE);
                SetTimeTotal();
                UpdateTimeSong();
                UpDateDataSong();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poss++;
                if (poss > musicData.size() - 1){
                    poss = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                CreateMediaPlayer();
                mediaPlayer.start();
                btnPlay.setVisibility(View.GONE);
                btnStop.setVisibility(View.VISIBLE);
                SetTimeTotal();
                UpdateTimeSong();
                UpDateDataSong();

            }
        });

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress()); // seekTo là đến đoạn nào của seekbar vs bài hát
            }
        });

    }

    private void CreateMediaPlayer() {
        mediaPlayer = MediaPlayer.create(MusicActivity.this, musicData.get(poss).getUrlMp3());



    }

    private void UpDateDataSong(){
        toolbar_music.setTitle(musicData.get(poss).getNameMusic());
        txt_music_detail.setText(musicData.get(poss).getNameMusic());
        txt_single_detail.setText(musicData.get(poss).getNameSingle());
        txt_lyric.setText(musicData.get(poss).getLyric());
        imageViewDisc.setImageResource(musicData.get(poss).getHinh());
    }

    private void UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                // update progress skSong
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        poss++;
                        if (poss > musicData.size() - 1){
                            poss = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }

                        CreateMediaPlayer();
                        mediaPlayer.start();
                        btnPlay.setVisibility(View.GONE);
                        btnStop.setVisibility(View.VISIBLE);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                // kiểm tra thời gian bài hét nếu kết thúc thì next bài
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void SetTimeTotal(){
        SimpleDateFormat dinhdangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhdangGio.format(mediaPlayer.getDuration()));
        // gán max của skSong = mediaPlayer.getDuration()
        skSong.setMax(mediaPlayer.getDuration());
    }

    private void setDataMp3() {
        imageViewDisc.setImageResource(Integer.parseInt(ava));
        txt_music_detail.setText("Bài hát: " + title);
        txt_single_detail.setText(single);
        txt_lyric.setText(lyric);

        imageViewDisc.setAnimation(animation);

    }

    private void setToolBar() {

        setSupportActionBar(toolbar_music);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_music.setNavigationIcon(R.drawable.arrowback2);
        toolbar_music.setTitle(title);
        toolbar_music.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();
            }
        });


    }

    private void initView() {
        txtTimeSong     = findViewById(R.id.textviewTimeSong);
        txtTimeTotal    = findViewById(R.id.textviewTimeTotal);
        skSong          = findViewById(R.id.seekbarSong);
        btnPrev         = findViewById(R.id.buttonPrev);
        btnPlay         = findViewById(R.id.buttonPlay);
        btnStop         = findViewById(R.id.buttonStop);
        btnNext         = findViewById(R.id.buttonNext);
        txt_lyric = findViewById(R.id.txt_lyric);
        imgHinh         = findViewById(R.id.imageViewDisc);



        toolbar_music   = findViewById(R.id.toolbar_music);
        txt_music_detail       = findViewById(R.id.txt_music_detail);
        txt_single_detail      = findViewById(R.id.txt_single_detail);
        imageViewDisc = findViewById(R.id.imageViewDisc);
    }
}
