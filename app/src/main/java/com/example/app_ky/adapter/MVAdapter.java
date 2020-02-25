package com.example.app_ky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.app_ky.R;
import com.example.app_ky.model.ItemClick;
import com.example.app_ky.model.MVData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MVAdapter extends RecyclerView.Adapter<MVAdapter.ViewHolder>{
    Context context;
    ArrayList<MVData> mvDatas;
    ItemClick itemClick;

    public MVAdapter(Context context, ArrayList<MVData> mvDatas, ItemClick itemClick) {
        this.context = context;
        this.mvDatas = mvDatas;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mv_row, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        holder.videoViewMp4.setVideoURI(mvDatas.get(position).getClipUrl());
//        holder.videoViewMp4.start();
//        MediaController mediaController = new MediaController(context);
//        // gán mediaController vào videoview
//        mediaController.setMediaPlayer(holder.videoViewMp4);
//        holder.videoViewMp4.setMediaController(mediaController);


        holder.img_mp4.setImageResource(mvDatas.get(position).getHinh());
        holder.img_mp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mvDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//        VideoView videoViewMp4;
        ImageView img_mp4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            videoViewMp4 = itemView.findViewById(R.id.videoViewMp4);
            img_mp4 = itemView.findViewById(R.id.img_mp4);

        }
    }
}
