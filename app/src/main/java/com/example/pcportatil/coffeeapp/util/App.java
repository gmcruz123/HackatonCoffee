package com.example.pcportatil.coffeeapp.util;
import android.app.Application;

import com.google.gson.Gson;

import org.greenrobot.greendao.database.Database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC portatil on 17/06/2017.
 */

public class App extends Application {

  public static   Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://calm-island-56741.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

    }
}
