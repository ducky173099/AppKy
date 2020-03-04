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

public class PlaceholderFragment extends Fragment implements ItemClick {
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
        mvMainDatas.add(new MvMainData(R.drawable.ymntt, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Yêu một người tổn thương","Nhật Phong", 0));
        mvMainDatas.add(new MvMainData(R.drawable.okmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Ok","Binz",0));
        mvMainDatas.add(new MvMainData(R.drawable.hcymv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Hơn cả yêu","Đức Phúc",0));
        mvMainDatas.add(new MvMainData(R.drawable.dndtdmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Đúng người đúng thời điểm","Thanh Hưng",0));
        mvMainDatas.add(new MvMainData(R.drawable.htcnmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Hết thương cạn nhớ","Đức Phúc",0));
        mvMainDatas.add(new MvMainData(R.drawable.lxlcmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Lá xa lìa cành","Lê Bảo Bình",0));
        mvMainDatas.add(new MvMainData(R.drawable.obsessionmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Obsession","EXO",0));
        mvMainDatas.add(new MvMainData(R.drawable.nlomv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Người lạ ơi","Orange x Karik",0));
        mvMainDatas.add(new MvMainData(R.drawable.splmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Simple love","Seachean x Obito",0));
        mvMainDatas.add(new MvMainData(R.drawable.vycddmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Vì yêu cứ đâm đầu","Min x Đen x Justatee",0));
        mvMainDatas.add(new MvMainData(R.drawable.bmkmv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Bánh mì không","Đạt-G x Uyên Duu",0));
        mvMainDatas.add(new MvMainData(R.drawable.lvymv, Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau),R.drawable.blink,"Loving you","Đen x Kimesse",0));


        mvMainAdapter = new MVMainAdapter(getContext(), mvMainDatas, this);
        recycler_Mp4.setAdapter(mvMainAdapter);


    }


    @Override
    public void onClick(int position) {

    }
}
