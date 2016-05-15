package com.javiernunez.puppies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Javier Núñez on 14/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        //contructor para pasarle la lista de mascotas
        this.mascotas=mascotas;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla nuestro layout cardview y lo pasa al ViewHolder para que obtenga cada elemento (los views)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        //Asocia cada elemento de la lista con cada view
        Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvPuntosCV.setText(String.valueOf(mascota.getPuntos()));
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvPuntosCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV   =(ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV  =(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvPuntosCV  =(TextView) itemView.findViewById(R.id.tvPuntosCV);

        }
    }
}
