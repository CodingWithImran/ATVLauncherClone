package com.codewithimran.atmlauncher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder>{
 Context context;
 ArrayList<ItemModals> listApp;
    public ItemAdapter(Context context, ArrayList<ItemModals> listApp) {
        this.context = context;
        this.listApp = listApp;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.appitemlayout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ItemModals modal = listApp.get(position);
        holder.name.setText(modal.getName());
        holder.icon.setImageDrawable(modal.getImage());
        Random r = new Random();
        holder.cardView.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));


          /* ====================================ClickListner On Every Widget of Apps===================================== */
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PackageManager manager = context.getPackageManager();
                    Intent intent = manager.getLaunchIntentForPackage(modal.getPackageName());
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return listApp.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView name;
        ImageView icon;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            name = itemView.findViewById(R.id.name);
            icon = itemView.findViewById(R.id.icon);
        }
    }
}
