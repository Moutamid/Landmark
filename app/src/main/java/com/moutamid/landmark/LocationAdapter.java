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

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LandmarkVH> {
    Context context;
    ArrayList<LocationsModel> list;

    public LocationAdapter(Context context, ArrayList<LocationsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LandmarkVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LandmarkVH(LayoutInflater.from(context).inflate(R.layout.locations,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkVH holder, int position) {
        LocationsModel model = list.get(holder.getAdapterPosition());

        holder.address.setText(model.address);
        holder.name.setText(model.name);

        holder.itemView.setOnClickListener(v -> {
            Stash.put(Constants.Location, model);
            context.startActivity(new Intent(context, MapsActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class LandmarkVH extends RecyclerView.ViewHolder{
        TextView address;
        TextView name;
        public LandmarkVH(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address);
            name = itemView.findViewById(R.id.name);
        }
    }

}
