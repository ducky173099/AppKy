package com.example.app_ky.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;

import com.example.app_ky.R;
import com.example.app_ky.adapter.MVMainAdapter;
import com.example.app_ky.model.ItemClick;
import com.example.app_ky.model.MvMainData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceholderFragment extends Fragment{
    RecyclerView recycler_Mp4;
    ArrayList<MvMainData> mvMainDatas;
    MVMainAdapter mvMainAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        recycler_Mp4 = view.findViewById(R.id.recycler_Mp4);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler_Mp4.setLayoutManager(layoutManager);

        mvMainDatas = new ArrayList<>();
        mvMainDatas.add(new MvMainData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"co don vi ai","nhatphong"));
        mvMainDatas.add(new MvMainData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"co don vi ai","nhatphong"));
        mvMainDatas.add(new MvMainData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"co don vi ai","nhatphong"));

        mvMainAdapter = new MVMainAdapter(getContext(), mvMainDatas);
        recycler_Mp4.setAdapter(mvMainAdapter);


    }



}
