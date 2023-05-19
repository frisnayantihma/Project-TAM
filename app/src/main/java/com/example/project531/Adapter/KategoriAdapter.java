package com.example.project531.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project531.Domain.KategoriDomain;
import com.example.project531.R;

import java.util.ArrayList;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {
    ArrayList<KategoriDomain> kategoriDomains;

    public KategoriAdapter(ArrayList<KategoriDomain> kategoriDomains) {
        this.kategoriDomains = kategoriDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_kategori, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(kategoriDomains.get(position).getTitle());
        String picUrl="";
        switch (position) {
            case 0: {
                picUrl = "robusta";
                break;
            }
            case 1: {
                picUrl = "arabika";
                break;
            }
            case 2: {
                picUrl = "gayo";
                break;
            }
            case 3: {
                picUrl = "luak";
                break;
            }
            case 4: {
                picUrl = "koplam";
                break;
            }
        }

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl, "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.categoryPic);

    }


    @Override
    public int getItemCount() {
        return kategoriDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
