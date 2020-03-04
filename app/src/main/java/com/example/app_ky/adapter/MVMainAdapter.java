package com.example.app_ky.adapter;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
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

public class MVMainAdapter extends RecyclerView.Adapter<MVMainAdapter.ViewHolder> {
    Context context;
    ArrayList<MvMainData> mvMainDatas;
    ItemClick itemClick;
    boolean checked;

    boolean isVideo = true;

    public MVMainAdapter(Context context, ArrayList<MvMainData> mvMainDatas, ItemClick itemClick) {
        this.context = context;
        this.mvMainDatas = mvMainDatas;
        this.itemClick = itemClick;
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

        holder.img_mvlist.setImageResource(mvMainDatas.get(position).getAvaSong());
        holder.img_avaMV.setImageResource(mvMainDatas.get(position).getHinh());
        holder.txt_song.setText(mvMainDatas.get(position).getSong());
        holder.txt_single_mv.setText(mvMainDatas.get(position).getSingle());

//        holder.video_list.setVideoURI(mvMainDatas.get(position).getClipUrl());
//        holder.video_list.pause();
//        MediaController mediaController = new MediaController(context);
//        // gán mediaController vào videoview
//        mediaController.setMediaPlayer(holder.video_list);
//        holder.video_list.setMediaController(mediaController);

        if (mvMainDatas.get(position).getStatus() == 1){
            holder.cb_like.setChecked(true);
        } else {
            holder.cb_like.setChecked(false);
        }

        holder.cb_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mvMainDatas.get(position).getStatus() == 1){
                    mvMainDatas.get(position).setStatus(0);
                    holder.cb_like.setChecked(false);
                } else {
                    mvMainDatas.get(position).setStatus(1);
                    holder.cb_like.setChecked(true);
                }

                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position);


            }
        });

//        checked = PreferenceManager.getDefaultSharedPreferences(context)
//                .getBoolean("cb_like", false);
//        holder.cb_like.setChecked(checked);
//        holder.cb_like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("cb_like", checked).commit();
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return mvMainDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//        VideoView video_list;
        ImageView img_mvlist;
        CircleImageView img_avaMV;
        TextView txt_song, txt_single_mv;
        CheckBox cb_like;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            video_list = itemView.findViewById(R.id.video_list);
            cb_like = itemView.findViewById(R.id.cb_like);
            img_avaMV = itemView.findViewById(R.id.img_avaMV);
            img_mvlist = itemView.findViewById(R.id.img_mvlist);
            txt_song = itemView.findViewById(R.id.txt_song);
            txt_single_mv = itemView.findViewById(R.id.txt_single_mv);
        }
    }
}
