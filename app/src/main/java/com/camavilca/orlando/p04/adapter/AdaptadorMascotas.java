package com.camavilca.orlando.p04.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.camavilca.orlando.p04.R;
import com.camavilca.orlando.p04.model.Mascotas;

import java.util.ArrayList;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.ViewHolder> {

    ArrayList<Mascotas> mascotas;

    public AdaptadorMascotas(ArrayList<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }

    public void setMascotas(ArrayList<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fot;
        TextView nomb;
        TextView raza;
        public ViewHolder(View itemView) {
            super(itemView);
            fot = (ImageView) itemView.findViewById(R.id.item_mascota_foto);
            nomb = (TextView)itemView.findViewById(R.id.item_mascota_nombre);
            raza = (TextView)itemView.findViewById(R.id.item_mascota_raza);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascotas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mascotas mascota = this.mascotas.get(position);
        holder.nomb.setText(mascota.getNombre());
        holder.raza.setText(mascota.getRaza());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


}
