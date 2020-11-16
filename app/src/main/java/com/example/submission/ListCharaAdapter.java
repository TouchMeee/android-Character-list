package com.example.submission;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListCharaAdapter extends RecyclerView.Adapter<ListCharaAdapter.ListViewHolder>{
    private final ArrayList<Chara> listChara;
    private OnItemClickCallback onItemClickCallback;

    public ListCharaAdapter(ArrayList<Chara> list) {
        this.listChara = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListCharaAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chara, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Chara chara = listChara.get(position);
        Glide.with(holder.itemView.getContext())
                .load(chara.getPhoto())
                .into(holder.imgPhoto);
        holder.tvName.setText(chara.getName());
        holder.tvDetail.setText(chara.getDetail());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listChara.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {

        return listChara.size ();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super (itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Chara data);
    }
}

