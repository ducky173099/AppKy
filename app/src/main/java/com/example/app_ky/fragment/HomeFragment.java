package com.example.app_ky.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.app_ky.R;
import com.example.app_ky.activity.MVActivity;
import com.example.app_ky.activity.MainActivity;
import com.example.app_ky.adapter.CategoryAdapter;
import com.example.app_ky.adapter.ChillAdapter;
import com.example.app_ky.adapter.MVAdapter;
import com.example.app_ky.model.Category;
import com.example.app_ky.model.ChillData;
import com.example.app_ky.model.ItemClick;
import com.example.app_ky.model.MVData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import static android.support.v4.media.session.MediaControllerCompatApi21.getPackageName;

//import static android.support.v4.media.session.MediaControllerCompatApi21.getPackageName;

public class HomeFragment extends Fragment implements ItemClick {
    ViewFlipper viewFlipper;
    Animation in, out;
    int[] arrayHinh = {R.drawable.p2, R.drawable.p3,R.drawable.p1, R.drawable.p4, R.drawable.p5};


    // Category
    RecyclerView recycler_catgory;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    // chill
    RecyclerView recycler_chill;
    ChillAdapter chillAdapter;
    ArrayList<ChillData> chillDatas;

    // MV
    RecyclerView recycler_mv;
    MVAdapter mvAdapter;
    ArrayList<MVData> mvDatas;

    MainActivity mainActivity;
    Intent intent;
    Uri uri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mainActivity = (MainActivity) getActivity();


        initView(view);
        setCategoryAdapter();
        setChillAdapter();
        setMVAdapter();



        // view flipper
        in = AnimationUtils.loadAnimation(getContext(), R.anim.face_in);
        out = AnimationUtils.loadAnimation(getContext(), R.anim.face_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

        for (int i = 0; i < arrayHinh.length; i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(arrayHinh[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        ////////////////////////////////////////////




        return view;
    }

    private void setMVAdapter() {
        mvDatas = new ArrayList<>();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recycler_mv.setLayoutManager(gridLayoutManager);

        mvDatas.add(new MVData(R.drawable.obse));
        mvDatas.add(new MVData(R.drawable.ecnhq));
        mvDatas.add(new MVData(R.drawable.solo));
        mvDatas.add(new MVData(R.drawable.lxlc));
        mvDatas.add(new MVData(R.drawable.cnkc));
        mvDatas.add(new MVData(R.drawable.ctcnta));

        mvAdapter = new MVAdapter(getContext(), mvDatas, this);
        recycler_mv.setAdapter(mvAdapter);

//        mvDatas.add(new MVData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau)));
//        mvDatas.add(new MVData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau)));
//        mvDatas.add(new MVData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau)));
//        mvDatas.add(new MVData(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau)));
//        mvAdapter = new MVAdapter(getContext(), mvDatas);
//        recycler_mv.setAdapter(mvAdapter);

    }

    private void setChillAdapter() {
        chillDatas = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler_chill.setLayoutManager(layoutManager);

        chillDatas.add(new ChillData(R.drawable.chill7, "justin bieber"));
        chillDatas.add(new ChillData(R.drawable.chill5, "G-EAZY"));
        chillDatas.add(new ChillData(R.drawable.chill9, "Dua Lipa"));
        chillDatas.add(new ChillData(R.drawable.chill3, "Ric"));
        chillDatas.add(new ChillData(R.drawable.chill4, "Pia Mia"));
        chillDatas.add(new ChillData(R.drawable.chill1, "Deep House"));
        chillDatas.add(new ChillData(R.drawable.chill6, "Đen Vâu"));
        chillDatas.add(new ChillData(R.drawable.chill8, "Ariana Grande Pro Unlimited"));

        chillAdapter = new ChillAdapter(getContext(), chillDatas);
        recycler_chill.setAdapter(chillAdapter);


    }

    private void setCategoryAdapter() {
        categories = new ArrayList<>();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recycler_catgory.setLayoutManager(gridLayoutManager);

        categories.add(new Category(R.drawable.usuk));
        categories.add(new Category(R.drawable.blink));
        categories.add(new Category(R.drawable.cafe));
        categories.add(new Category(R.drawable.krazy));
        categories.add(new Category(R.drawable.usuk));
        categories.add(new Category(R.drawable.blink));
        categories.add(new Category(R.drawable.cafe));
        categories.add(new Category(R.drawable.krazy));

        categoryAdapter = new CategoryAdapter(getContext(), categories);
        recycler_catgory.setAdapter(categoryAdapter);

    }

    private void initView(View view) {
        viewFlipper = view.findViewById(R.id.viewFlipper);
        recycler_catgory = view.findViewById(R.id.recycler_catgory);
        recycler_chill = view.findViewById(R.id.recycler_chill);
        recycler_mv = view.findViewById(R.id.recycler_mv);

    }


    @Override
    public void onClick(int position) {
        switch (position){
            case 0:
                uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.chuyennhuchuabatdau);
                intent = new Intent(getContext(), MVActivity.class);
                intent.putExtra("uri", uri+"");
                startActivity(intent);
                break;
            case 1:
                uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.ecnhq);
                intent = new Intent(getContext(), MVActivity.class);
                intent.putExtra("uri", uri+"");
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(mainActivity, "hahaaa" + position, Toast.LENGTH_SHORT).show();

                break;
            case 3:
                Toast.makeText(mainActivity, "hahaaa" + position, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
