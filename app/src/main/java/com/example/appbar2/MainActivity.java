package com.example.appbar2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.appbar2.adapter.ContactoAdaptdor;
import com.example.appbar2.adapter.PageAdapter;
import com.example.appbar2.fragment.PerfilFragment;
import com.example.appbar2.fragment.RecyclerViewFragment;
import com.example.appbar2.pojo.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class MainActivity extends AppCompatActivity {

 //   ArrayList<Contacto> contactos;
 //   private RecyclerView listaContactos;
    private ImageView ivEstrella;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if (toolbar != null) {
            //setSupportActionBar(miActionBar);
            setSupportActionBar(toolbar);
        }



 //       ivEstrella = findViewById(R.id.ivEstrella);

  /*      ivEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(ivEstrella, "Se dio click", Snackbar.LENGTH_SHORT).show();
                irSegundaActividad(v);
            }
        });*/


      /*  listaContactos = (RecyclerView)findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();
   */
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_opciones,menu);

        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spannableString = new SpannableString(item.getTitle());
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannableString.length(), 0); // Cambia Color.WHITE por el color deseado
            item.setTitle(spannableString);
        }


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.i("TAG", "Mensaje de información "+item.getItemId());
        switch (item.getItemId()){
            case 2131230972:
                Intent intent = new Intent(this, Formulario2.class);
                startActivity(intent);
                break;

            case 2131230971:
                Intent intent2 = new Intent(this, AcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

  /*  public void inicializaAdaptador(){
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

    }*/

}