package com.example.alienapp.Interface;

import com.example.alienapp.Model.Alien;

import retrofit2.Call;
import retrofit2.http.POST;

//Aqui se codifica el tipo de peticion que se esta haciendo a la API

public interface ApiAlien {



    @POST("/Aliens")
    Call<Alien> addAlien();

}
