package com.example.pcportatil.coffeeapp.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pcportatil.coffeeapp.R;
import com.example.pcportatil.coffeeapp.adapters.PlantacionAdapter;
import com.example.pcportatil.coffeeapp.databinding.FragmentMainBinding;
import com.example.pcportatil.coffeeapp.models.Plantacion;
import com.example.pcportatil.coffeeapp.net.PlantacionesClient;
import com.example.pcportatil.coffeeapp.util.App;
import com.example.pcportatil.coffeeapp.util.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements PlantacionAdapter.onPlantacionListener {

    FragmentMainBinding binding;
    PlantacionAdapter adapterPlantacion;
    PlantacionesClient client;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        adapterPlantacion = new PlantacionAdapter(getLayoutInflater(null), new ArrayList<Plantacion>(),this);
        binding.recycler.setAdapter(adapterPlantacion);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));


/*        if (getArguments() != null) {
            int seleccion = getArguments().getInt("seleccion", 1);

            switch (seleccion) {

                case 1:


                    break;

            }
        }
  */      client = App.retrofit.create(PlantacionesClient.class);
        return binding.getRoot();

    }


    public static MainFragment instance(int seleccion) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("seleccion", seleccion);
        fragment.setArguments(args);
     return fragment;
    }

    @Override
    public void onResume() {
            super.onResume();
            loadRest();
    }



    private void loadRest() {
        Call<List<Plantacion>> request = client.allPlan();
        request.enqueue(new Callback<List<Plantacion>>() {
            @Override
            public void onResponse(Call<List<Plantacion>> call, Response<List<Plantacion>> response) {
                if (response.isSuccessful()) {
                    Log.d("label","si entro");
                    Data.plantaciones = response.body();
                    adapterPlantacion.setData(Data.plantaciones);
                }


            }

            @Override
            public void onFailure(Call<List<Plantacion>> call, Throwable t) {
                Toast.makeText(getActivity(),R.string.error_servidor_registro,Toast.LENGTH_SHORT).show();
            }

        });


    }


    @Override
    public void onPlantacionClick(int position) {

        Log.d("click", "onPlantacionClick: ");
    }
}
