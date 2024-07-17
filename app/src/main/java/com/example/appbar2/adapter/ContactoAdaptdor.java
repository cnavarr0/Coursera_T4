package com.example.appbar2.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.appbar2.MainActivity;
import com.example.appbar2.fragment.PerfilFragment;
import com.example.appbar2.pojo.Contacto;
import com.example.appbar2.R;

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

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = ((MainActivity) v.getContext()).findViewById(R.id.viewPager);

                viewPager.setCurrentItem(1);
                PerfilFragment fragment2 = (PerfilFragment) ((PageAdapter) viewPager.getAdapter()).getItem(1);
               // ImageView foto = new ImageView()contacto.
                fragment2.updateData(contacto.getNombre(),contacto.getFoto());
            }
                //Toast.makeText(this,contacto.getNombre(), Toast.LENGTH_SHORT).show();
          /*      Bundle bundle = new Bundle();
                bundle.putString("nombre", contacto.getNombre());


                PerfilFragment fragment2 = new PerfilFragment();
                fragment2.setArguments(bundle);

                FragmentTransaction transaction = ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new PerfilFragment()); // Asegúrate de que R.id.fragment_container es el contenedor de tus fragmentos
                transaction.addToBackStack(null);
                transaction.commit();




            }*/
        });
    }

    @Override
    public int getItemCount() {  // Cantidad de elementos que tiene la lista de contactos
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;

       // private ViewPager viewPager;  //

        public ContactoViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
         //   tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
       //     viewPager =(ViewPager) itemView.findViewById(R.id.viewPager);

        }
    }
}