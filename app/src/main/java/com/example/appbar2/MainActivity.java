package com.example.appbar2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private ImageView ivEstrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ivEstrella = findViewById(R.id.ivEstrella);

        ivEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(ivEstrella, "Se dio click", Snackbar.LENGTH_SHORT).show();
                irSegundaActividad(v);
            }
        });


        listaContactos = (RecyclerView)findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();

    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

    public void inicializaAdaptador(){
        ContactoAdaptdor adaptador = new ContactoAdaptdor(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.mipmap.perro1_foreground,"Christian", "6461234567", "christian@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro2_foreground,"Luis", "6461111111", "luis@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro3_foreground,"Dario", "6462222222", "dario@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro4_foreground,"Alberto", "6463333333", "alberto@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro5_foreground,"Xavier", "646777777", "xavi@hotmail.com"));

    }

}