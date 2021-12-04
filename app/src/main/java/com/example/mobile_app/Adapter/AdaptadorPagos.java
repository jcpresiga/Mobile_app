package com.example.mobile_app.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobile_app.Pagos;
import com.example.mobile_app.R;
import java.util.ArrayList;

public class AdaptadorPagos extends RecyclerView.Adapter<AdaptadorPagos.ViewHolderPagos>{


    ArrayList<Pagos> pagos;

    public AdaptadorPagos(ArrayList<Pagos> pagos) {
        this.pagos = pagos;
    }

    @NonNull
    @Override
    public AdaptadorPagos.ViewHolderPagos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pagos, null, false);
        return new ViewHolderPagos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPagos.ViewHolderPagos holder, int position) {
        holder.etiSuscripcion.setText(pagos.get(position).getId_suscripcion().toString());
        holder.etiFechaFinal.setText(pagos.get(position).getFecha_final());

    }

    @Override
    public int getItemCount() {        return pagos.size();    }

    public class ViewHolderPagos extends RecyclerView.ViewHolder {
        TextView etiSuscripcion, etiFechaFinal;
        public ViewHolderPagos (View itemView){
            super(itemView);
            etiSuscripcion = itemView.findViewById(R.id.campoFactura);
            etiFechaFinal= itemView.findViewById(R.id.campoPagoHasta);
        }
    }

}
