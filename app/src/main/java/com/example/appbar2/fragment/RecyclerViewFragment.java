package com.example.appbar2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appbar2.R;
import com.example.appbar2.adapter.ContactoAdaptdor;
import com.example.appbar2.pojo.Contacto;
import com.example.appbar2.presentador.IRecyclerViewFragmentPresenter;
import com.example.appbar2.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerViewFragment newInstance(String param1, String param2) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());


      /* inicializarListaContactos();
        inicializaAdaptador(); */


        return v;
    }

  /*  public void inicializaAdaptador(){
        ContactoAdaptdor adaptador = new ContactoAdaptdor(contactos);

        //  ContactoAdaptdor adaptador = new ContactoAdaptdor(contactos,getActivity()):
        listaContactos.setAdapter(adaptador);
    }*/

   /* public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.mipmap.perro1_foreground,"Christian", "6461234567", "christian@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro2_foreground,"Luis", "6461111111", "luis@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro3_foreground,"Dario", "6462222222", "dario@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro4_foreground,"Alberto", "6463333333", "alberto@hotmail.com"));
        contactos.add(new Contacto(R.mipmap.perro5_foreground,"Xavier", "646777777", "xavi@hotmail.com"));

    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptdor crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptdor adaptador = new ContactoAdaptdor(contactos);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptdor adaptador) {
        listaContactos.setAdapter(adaptador);

    }
}