package com.example.aplicacionbase.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionbase.R;
import com.example.aplicacionbase.RecyclerListas.AdapterPeliculas;
import com.example.aplicacionbase.databinding.FragmentListadopeliculasBinding;
import com.google.android.material.snackbar.Snackbar;


public class ListadoPeliculasFragment extends Fragment {

    private FragmentListadopeliculasBinding binding;
    private RecyclerView listado;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentListadopeliculasBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listado = view.findViewById(R.id.peliculasID);
        listado.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        AdapterPeliculas adaptador=new AdapterPeliculas();
        listado.setAdapter(adaptador);
        View vistaPrinci=view;



        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, adaptador.datos.get(listado.getChildAdapterPosition(view)), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListadoPeliculasFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}