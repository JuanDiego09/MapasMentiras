package com.example.juan.mapasmentiras.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.mapasmentiras.R;
import com.example.juan.mapasmentiras.entidades.LugaresVo;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolderView> implements View.OnClickListener {


    ArrayList<LugaresVo> listaLugares;
    View.OnClickListener listener;

    public Adapter(ArrayList<LugaresVo> listaLugares) {
        this.listaLugares = listaLugares;
    }

    @Override
    public AdapterHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_adapter,null,false);
        view.setOnClickListener(this);
        return new AdapterHolderView(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolderView holder, int position) {
        holder.imagen.setImageResource(listaLugares.get(position).getImagen());
        holder.nombre.setText(listaLugares.get(position).getNombre());
        holder.descripcion.setText(listaLugares.get(position).getDescripcionCorta());
    }

    @Override
    public int getItemCount() {
        return listaLugares.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class AdapterHolderView extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre,descripcion,ubicacion;
        public AdapterHolderView(View itemView) {
            super(itemView);
            imagen=itemView.findViewById(R.id.campoImagen);
            nombre=itemView.findViewById(R.id.nombre);
            descripcion=itemView.findViewById(R.id.descripcionCorta);
            ubicacion=itemView.findViewById(R.id.ubicacion);
        }
    }
}
