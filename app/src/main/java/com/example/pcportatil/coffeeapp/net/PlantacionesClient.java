package com.example.pcportatil.coffeeapp.net;

import com.example.pcportatil.coffeeapp.models.Plantacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by PC portatil on 17/06/2017.
 */

public interface PlantacionesClient {

    //region Listar
    @GET("plantaciones")
    Call<List<Plantacion>>allPlan();

    // sin uso

    @GET("restaurantes")
    Call<List<Plantacion>> allRes();

    @GET("reservasiones") //concatenar el id del usuario
    Call<List<Plantacion>> allReservas();

    @GET("promociones") //concatenar el id del usuario
    Call<List<Plantacion>> allPromo();

    @GET("eventos") //concatenar el id del usuario
    Call<List<Plantacion>> allEventos();
    //endregion
}
