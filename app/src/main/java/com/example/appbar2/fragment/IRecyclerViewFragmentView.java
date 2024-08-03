package com.example.appbar2.fragment;

import com.example.appbar2.adapter.ContactoAdaptdor;
import com.example.appbar2.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView
{
    public void generarLinearLayoutVertical();

    public ContactoAdaptdor crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptdor adaptador);
}
