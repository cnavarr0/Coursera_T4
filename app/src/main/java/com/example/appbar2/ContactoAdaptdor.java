package com.example.appbar2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactoAdaptdor extends RecyclerView.Adapter<ContactoAdaptdor.ContactoViewHolder> {

    ArrayList<Contacto> contactos;

    public ContactoAdaptdor(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }

    //Inflar el layout y lo pasará al viewHolder para que obtenga los view
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Da vida al cardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);

        return new ContactoViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
       // contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() {  // Cantidad de elementos que tiene la lista de contactos
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;

        public ContactoViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
         //   tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);

        }
    }
}
