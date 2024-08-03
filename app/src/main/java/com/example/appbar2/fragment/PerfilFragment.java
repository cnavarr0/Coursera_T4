package com.example.appbar2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbar2.R;
import com.example.appbar2.adapter.ContactoAdaptdor;
import com.example.appbar2.adapter.PerfilAdaptador;
import com.example.appbar2.pojo.Contacto;
import com.example.appbar2.pojo.Imagenes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView tvFragPerfil;
    ImageView ivFotoPerfil;

    private RecyclerView listaImagenes;
    private ArrayList<Imagenes> imagenes;


    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        //tvFragPerfil.findViewById(R.id.tvFragPerfil);
      //  tvFragPerfil.setText("Cambio el text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_perfil, container, false);

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaImagenes = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager llm = new GridLayoutManager (getActivity(),2);
      //  llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaImagenes.setLayoutManager(llm);
        inicializarListaImagenes();
        inicializaAdaptador();
        return v;

    }
    public void updateData(String nombre, int foto) {

        tvFragPerfil = getView().findViewById(R.id.tvFragPerfil);
        ivFotoPerfil = getView().findViewById(R.id.imgPerf);
        tvFragPerfil.setText(nombre);
        ivFotoPerfil.setImageResource(foto);

    }

    public void inicializaAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(imagenes);
        listaImagenes.setAdapter(adaptador);
    }

    public void inicializarListaImagenes(){
        imagenes = new ArrayList<Imagenes>();

        imagenes.add(new Imagenes(R.mipmap.cari11_foreground,"1"));
        imagenes.add(new Imagenes(R.mipmap.cari22_foreground,"2"));
        imagenes.add(new Imagenes(R.mipmap.cari33_foreground,"3"));
        imagenes.add(new Imagenes(R.mipmap.cari44_foreground,"4"));
        imagenes.add(new Imagenes(R.mipmap.cari55_foreground,"5"));
        imagenes.add(new Imagenes(R.mipmap.cari66_foreground,"6"));

    }


}