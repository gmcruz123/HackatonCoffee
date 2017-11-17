package com.example.pcportatil.coffeeapp.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pcportatil.coffeeapp.R;
import com.example.pcportatil.coffeeapp.databinding.TemplatePlantacionesBinding;
import com.example.pcportatil.coffeeapp.models.Plantacion;

import java.util.List;

/**
 * Created by PC portatil on 27/10/2017.
 */

public class PlantacionAdapter  extends RecyclerView.Adapter<PlantacionAdapter.PlantacionHolder> {

    //region Implementacion metodos recycler
    @Override
    public PlantacionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_plantaciones,parent,false);
        return new PlantacionHolder(v);
    }

    @Override
    public void onBindViewHolder(PlantacionHolder holder, int position) {

        holder.binding.setPlantacion(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    //endregion

    public interface onPlantacionListener{
        void onPlantacionClick(int position);

    }

    LayoutInflater inflater;
    List<Plantacion> data;
    onPlantacionListener listener;



    public PlantacionAdapter(LayoutInflater inflater, List<Plantacion> data , onPlantacionListener listener) {
        this.inflater = inflater;
        this.data = data;
        this.listener = listener;
    }


    public void onItemClick(int position){

        listener.onPlantacionClick(position);


    }


    public void  setData(List<Plantacion> data){
        this.data = data;
        notifyDataSetChanged();
    }

    //region Holder
    static  class PlantacionHolder extends RecyclerView.ViewHolder{

        TemplatePlantacionesBinding binding;

        public PlantacionHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
    //endregion
}
