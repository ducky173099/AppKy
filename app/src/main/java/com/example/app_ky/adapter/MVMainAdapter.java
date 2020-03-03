package com.example.app_ky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.app_ky.R;
import com.example.app_ky.activity.MainActivity;
import com.example.app_ky.model.ItemClick;
import com.example.app_ky.model.MvMainData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MVMainAdapter extends RecyclerView.Adapter<MVMainAdapter.ViewHolder>{
    Context context;
    ArrayList<MvMainData> mvMainDatas;
    ItemClick itemClick;

    public MVMainAdapter(Context context, ArrayList<MvMainData> mvMainDatas) {
        this.context = context;
        this.mvMainDatas = mvMainDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mp4_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.video_list.setVideoURI(mvMainDatas.get(position).getClipUrl());

        holder.img_avaMV.setImageResource(mvMainDatas.get(position).getHinh());
        holder.txt_song.setText(mvMainDatas.get(position).getSong());
        holder.txt_single_mv.setText(mvMainDatas.get(position).getSingle());

        holder.video_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.video_list.start();
                MediaController mediaController = new MediaController(context);
                // gán mediaController vào videoview
                mediaController.setMediaPlayer(holder.video_list);
                holder.video_list.setMediaController(mediaController);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mvMainDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        VideoView video_list;
        CircleImageView img_avaMV;
        TextView txt_song, txt_single_mv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            video_list = itemView.findViewById(R.id.video_list);
            img_avaMV = itemView.findViewById(R.id.img_avaMV);
            txt_song = itemView.findViewById(R.id.txt_song);
            txt_single_mv = itemView.findViewById(R.id.txt_single_mv);
        }
    }
}
