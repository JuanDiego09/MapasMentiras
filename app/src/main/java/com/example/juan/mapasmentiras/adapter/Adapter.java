package com.example.juan.mapasmentiras.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.mapasmentiras.R;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolderView> implements View.OnClickListener {


    View.OnClickListener listener;

    public Adapter(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public AdapterHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_adapter,null,false);
        view.setOnClickListener(this);
        return new AdapterHolderView(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolderView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {

    }

    public class AdapterHolderView extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre,descripcion,ubicacion;
        public AdapterHolderView(View itemView) {
            super(itemView);
        }
    }
}
