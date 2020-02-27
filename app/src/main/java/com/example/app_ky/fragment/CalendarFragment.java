package com.example.app_ky.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app_ky.R;
import com.example.app_ky.activity.MusicActivity;
import com.example.app_ky.adapter.MusicAdapter;
import com.example.app_ky.model.ItemClick;
import com.example.app_ky.model.MusicData;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarFragment extends Fragment implements ItemClick {
    RecyclerView recycler_music;
    ArrayList<MusicData> musicData;
    MusicAdapter musicAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calender, container, false);

        initView(view);
        setMusicAdapter();

        return view;
    }

    private void setMusicAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_music.setLayoutManager(layoutManager);

        musicData = new ArrayList<>();
        musicData.add(new MusicData(R.drawable.m2,"Bước qua đời nhau","Lê Bảo Bình", R.raw.buocquadoinhau, getResources().getString(R.string.buocquadoinhau)));
        musicData.add(new MusicData(R.drawable.m3,"Có tất cả nhưng thiếu anh","Có tất cả nhưng thiếu anh", R.raw.cotatcanhungthieua,getResources().getString(R.string.cotatcanhungthieuanh)));
        musicData.add(new MusicData(R.drawable.m4,"Đếm cừu","Han sara", R.raw.demcuu,getResources().getString(R.string.demcuu)));
        musicData.add(new MusicData(R.drawable.m5,"Người phản bội","Lê Bảo Bình",R.raw.nguoiphanboi,getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.m2,"Bước qua đời nhau","Lê Bảo Bình", R.raw.buocquadoinhau, getResources().getString(R.string.buocquadoinhau)));
        musicData.add(new MusicData(R.drawable.m3,"Có tất cả nhưng thiếu anh","Có tất cả nhưng thiếu anh", R.raw.cotatcanhungthieua,getResources().getString(R.string.cotatcanhungthieuanh)));
        musicData.add(new MusicData(R.drawable.m4,"Đếm cừu","Han sara", R.raw.demcuu,getResources().getString(R.string.demcuu)));
        musicData.add(new MusicData(R.drawable.m5,"Người phản bội","Lê Bảo Bình",R.raw.nguoiphanboi,getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.m2,"Bước qua đời nhau","Lê Bảo Bình", R.raw.buocquadoinhau, getResources().getString(R.string.buocquadoinhau)));
        musicData.add(new MusicData(R.drawable.m3,"Có tất cả nhưng thiếu anh","Có tất cả nhưng thiếu anh", R.raw.cotatcanhungthieua,getResources().getString(R.string.cotatcanhungthieuanh)));
        musicData.add(new MusicData(R.drawable.m4,"Đếm cừu","Han sara", R.raw.demcuu,getResources().getString(R.string.demcuu)));
        musicData.add(new MusicData(R.drawable.m5,"Người phản bội","Lê Bảo Bình",R.raw.nguoiphanboi,getResources().getString(R.string.nguoiphanboi)));



        musicAdapter = new MusicAdapter(getContext(), musicData, this);
        recycler_music.setAdapter(musicAdapter);


    }

    private void initView(View view) {
        recycler_music = view.findViewById(R.id.recycler_music);


    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getContext(), MusicActivity.class);
        intent.putExtra("ava", musicData.get(position).getHinh() + "");
        intent.putExtra("title", musicData.get(position).getNameMusic());
        intent.putExtra("single",musicData.get(position).getNameSingle());
        intent.putExtra("music", musicData.get(position).getUrlMp3() + "");
        intent.putExtra("lyric", musicData.get(position).getLyric());
        intent.putExtra("pos", position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("ARRAYLIST",(Serializable)musicData);
        intent.putExtra("BUNDLE",bundle);
        startActivity(intent);


    }
}
