package com.example.app_ky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_ky.R;
import com.example.app_ky.model.ItemClick;
import com.example.app_ky.model.MusicData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{
    Context context;
    ArrayList<MusicData> musicData;
    ItemClick itemClick;

    public MusicAdapter(Context context, ArrayList<MusicData> musicData, ItemClick itemClick) {
        this.context = context;
        this.musicData = musicData;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.music_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.img_music.setImageResource(musicData.get(position).getHinh());
        holder.txt_name_music.setText(musicData.get(position).getNameMusic());
        holder.txt_single.setText(musicData.get(position).getNameSingle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return musicData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_music;
        TextView txt_name_music, txt_single;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_music = itemView.findViewById(R.id.img_music);
            txt_name_music = itemView.findViewById(R.id.txt_name_music);
            txt_single = itemView.findViewById(R.id.txt_single);
        }
    }
}
