package com.example.pcportatil.coffeeapp.net;


import com.example.pcportatil.coffeeapp.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by PC portatil on 15/06/2017.
 */

public interface UsersClient {
    @POST("users/signin")
    Call< RegisterResponse> register(@Body User user);

    @POST("users/login")
    Call<SimpleResponse> login(@Body User user);




}
