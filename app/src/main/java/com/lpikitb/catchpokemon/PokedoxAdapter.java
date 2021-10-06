package com.lpikitb.catchpokemon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class PokedoxAdapter extends RecyclerView.Adapter<PokedoxAdapter.MyViewHolder> {
    Context context;
    List<PokedoxItem> pokedox;
    public PokedoxAdapter (Context context, List<PokedoxItem> data_pokedox) {
        this.context = context;
        this.pokedox = data_pokedox;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listpokemon_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.tvName.setText(pokedox.get(position).getName());
        holder.tvType.setText(pokedox.get(position).getType());

        final String urlPokePhoto = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokedox.get(position).getPhoto();
        Picasso.with(context).load(urlPokePhoto).into(holder.ivPokePhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent varIntent = new Intent(context, DetailActivity.class);

                varIntent.putExtra("NM_POKEDOX", pokedox.get(position).getName());
                varIntent.putExtra("TP_POKEDOX", pokedox.get(position).getType());
                varIntent.putExtra("WG_POKEDOX", pokedox.get(position).getWeight());
                varIntent.putExtra("HG_POKEDOX", pokedox.get(position).getHeight());
                varIntent.putExtra("PH_POKEDOX", urlPokePhoto);

                context.startActivity(varIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokedox.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPokePhoto;
        TextView tvName, tvType;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivPokePhoto = (ImageView) itemView.findViewById(R.id.ivPokePhoto);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvType = (TextView) itemView.findViewById(R.id.tvType);
        }
    }
}
