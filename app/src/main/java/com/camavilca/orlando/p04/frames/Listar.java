package com.camavilca.orlando.p04.frames;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camavilca.orlando.p04.R;
import com.camavilca.orlando.p04.adapter.AdaptadorMascotas;
import com.camavilca.orlando.p04.model.Mascotas;
import com.camavilca.orlando.p04.repository.RepositoryMascota;

import java.util.ArrayList;
import java.util.List;

public class Listar extends Fragment {
    private static final String TAG = Listar.class.getSimpleName();
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView recyclerView;

    public Listar() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_listar, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.lista_mascotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Mascotas> mascotas = RepositoryMascota.listar();
        recyclerView.setAdapter(new AdaptadorMascotas((ArrayList<Mascotas>) mascotas));
        return view;
    }
    public void onButtonPressed(Uri uri) {
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AdaptadorMascotas adaptadorMascotas = (AdaptadorMascotas)recyclerView.getAdapter();
        List<Mascotas> mascotas = RepositoryMascota.listar();
        adaptadorMascotas.setMascotas((ArrayList<Mascotas>) mascotas);
        adaptadorMascotas.notifyDataSetChanged();
    }
}
