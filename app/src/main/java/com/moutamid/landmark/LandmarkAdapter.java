package com.moutamid.landmark;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fxn.stash.Stash;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkVH> {
    Context context;
    ArrayList<LandmarkModel> list;

    public LandmarkAdapter(Context context, ArrayList<LandmarkModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LandmarkVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LandmarkVH(LayoutInflater.from(context).inflate(R.layout.landmarks,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkVH holder, int position) {
        LandmarkModel model = list.get(holder.getAdapterPosition());

        holder.icon.setImageResource(model.icon);
        holder.name.setText(model.type);

        holder.itemView.setOnClickListener(v -> {
            Stash.put(Constants.Pass, model);
            context.startActivity(new Intent(context, LocationsActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class LandmarkVH extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView name;
        public LandmarkVH(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
        }
    }

}
