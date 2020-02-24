package com.example.app_ky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_ky.R;
import com.example.app_ky.model.ChillData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChillAdapter extends RecyclerView.Adapter<ChillAdapter.ViewHolder>{
    Context context;
    ArrayList<ChillData> chillDatas;

    public ChillAdapter(Context context, ArrayList<ChillData> chillDatas) {
        this.context = context;
        this.chillDatas = chillDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chill_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img_chill.setImageResource(chillDatas.get(position).getHinh());
        holder.txt_namesingle.setText(chillDatas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return chillDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_chill;
        TextView txt_namesingle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_chill = itemView.findViewById(R.id.img_chill);
            txt_namesingle = itemView.findViewById(R.id.txt_namesingle);
        }
    }
}
