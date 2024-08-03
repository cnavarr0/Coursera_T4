package com.example.appbar2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.appbar2.MainActivity;
import com.example.appbar2.fragment.PerfilFragment;
import com.example.appbar2.pojo.Contacto;
import com.example.appbar2.R;
import com.example.appbar2.pojo.Imagenes;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Imagenes> imagenes;


    public PerfilAdaptador(ArrayList<Imagenes> imagenes){

        this.imagenes = imagenes;


    }

    //Inflar el layout y lo pasará al viewHolder para que obtenga los view
    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Da vida al cardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);

        return new PerfilViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {
        Imagenes imagen = imagenes.get(position);
       perfilViewHolder.imgFoto.setImageResource(imagen.getFoto());
        perfilViewHolder.tvRaitCV.setText(imagen.getRait());

       // });
    }

    @Override
    public int getItemCount() {  // Cantidad de elementos que tiene la lista de contactos
        return imagenes.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvRaitCV;
        private TextView tvTelefonoCV;


        public PerfilViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoPerf);
            tvRaitCV = (TextView) itemView.findViewById(R.id.tvRaitCVPerf);


        }
    }
}

