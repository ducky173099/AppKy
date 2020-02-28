package com.example.app_ky.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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

public class MusicFragment extends Fragment implements ItemClick, View.OnClickListener {
    RecyclerView recycler_music;
    ArrayList<MusicData> musicData;
    ArrayList<MusicData> dataSearch;
    MusicAdapter musicAdapter;

    EditText edtsearch_music;
    ImageView del_music;

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
        musicData.add(new MusicData(R.drawable.chill7,"Mic Drop","Steve Aoki", R.raw.micdrop, getResources().getString(R.string.buocquadoinhau)));
        musicData.add(new MusicData(R.drawable.chill5,"Bước qua đời nhau","Lê Bảo Bình", R.raw.buocquadoinhau, getResources().getString(R.string.buocquadoinhau)));
        musicData.add(new MusicData(R.drawable.chill9,"Có tất cả nhưng thiếu anh","Có tất cả nhưng thiếu anh", R.raw.cotatcanhungthieua,getResources().getString(R.string.cotatcanhungthieuanh)));
        musicData.add(new MusicData(R.drawable.chill6,"Đếm cừu","Han sara", R.raw.demcuu,getResources().getString(R.string.demcuu)));
        musicData.add(new MusicData(R.drawable.chill3,"Người phản bội","Lê Bảo Bình",R.raw.nguoiphanboi,getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill1, "Hãy trao cho anh", "Sơn Tùng M-tp",R.raw.haytraochoanh, getResources().getString(R.string.haytraochoanh)));
        musicData.add(new MusicData(R.drawable.chill2, "Từng yêu", "Phan Duy Anh",R.raw.tungyeu, getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill3, "Vì yêu cứ đâm đầu", "Min x Đen",R.raw.viyeucudamdau, getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill4, "Một triệu like", "Đen",R.raw.mottrieulike, getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill5, "Làm gì phải hốt", "Hoàng Thùy Linh x Justatee x Đen",R.raw.lamgiphaihot, getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill6, "Hết thương cạn nhớ", "Đức Phúc",R.raw.hetthuongcannho, getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill7, "Hơn cả yêu", "Đức Phúc",R.raw.honcayeu, getResources().getString(R.string.nguoiphanboi)));
        musicData.add(new MusicData(R.drawable.chill8, "Bài này chill phết", "Đen x Min",R.raw.bainaychill, getResources().getString(R.string.nguoiphanboi)));


        musicAdapter = new MusicAdapter(getContext(), musicData, this);
        recycler_music.setAdapter(musicAdapter);

        EventSearch();


    }

    private void EventSearch() {
        dataSearch = new ArrayList<>();

        edtsearch_music.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                Log.e("search", "onTextChanged: " );
                fillterSearch(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            private void fillterSearch(String text){
                dataSearch.clear();
                Log.e("TAG","CHECK DATA SIZE:"+musicData.size());
                for (MusicData data: musicData){
                    if (data.getNameMusic().toUpperCase().contains(text.toUpperCase())){
                        Log.e("TAG","CHECK DATA add:");
                        dataSearch.add(data);
                    }
                }

                musicAdapter.setMusicData(dataSearch);
            }
        });

        del_music.setOnClickListener(this);


    }

    private void initView(View view) {
        recycler_music = view.findViewById(R.id.recycler_music);
        edtsearch_music = view.findViewById(R.id.edtsearch_music);
        del_music = view.findViewById(R.id.del_music);

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

    @Override
    public void onClick(View v) {
        edtsearch_music.getText().clear();
    }
}
