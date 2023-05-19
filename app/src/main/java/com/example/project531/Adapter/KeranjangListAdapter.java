package com.example.project531.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project531.Domain.CoffeDomain;
import com.example.project531.Helper.ManagementKeranjang;
import com.example.project531.Interface.ChangeNumberItemsListener;
import com.example.project531.R;

import java.util.ArrayList;

public class KeranjangListAdapter extends RecyclerView.Adapter<KeranjangListAdapter.ViewHolder> {
    ArrayList<CoffeDomain> listCoffeSelected;
    private ManagementKeranjang managementKeranjang;
    ChangeNumberItemsListener changeNumberItemsListener;

    public KeranjangListAdapter(ArrayList<CoffeDomain> listCoffeSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listCoffeSelected = listCoffeSelected;
        managementKeranjang = new ManagementKeranjang(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cart, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listCoffeSelected.get(position).getTitle());
        holder.feeEachItem.setText("RP" + listCoffeSelected.get(position).getBayar());
        holder.totalEachItem.setText("RP" + Math.round((listCoffeSelected.get(position).getNumberInCart() * listCoffeSelected.get(position).getBayar())));
        holder.num.setText(String.valueOf(listCoffeSelected.get(position).getNumberInCart()));


        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listCoffeSelected.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managementKeranjang.plusNumberFood(listCoffeSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.minusItem.setOnClickListener(v -> managementKeranjang.minusNumberFood(listCoffeSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

    }


    @Override
    public int getItemCount() {
        return listCoffeSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberItemTxt);

        }
    }
}
