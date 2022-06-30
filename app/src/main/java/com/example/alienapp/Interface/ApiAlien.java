package com.example.alienapp.Interface;

import com.example.alienapp.Model.Alien;
import com.example.alienapp.Model.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//Aqui se codifica el tipo de peticion que se esta haciendo a la API

public interface ApiAlien {


   @FormUrlEncoded
    @POST("aliens")
    Call<Alien> addAlien(
            @Field("alien_usuario") String alien_usuario,
            @Field("alien_nombre") String alien_nombre,
            @Field("alien_ap") String alien_ap,
            @Field("alien_am") String alien_am,
            @Field("alien_correo") String alien_correo,
            @Field("alien_contrasenia") String alien_contrasenia,
            @Field("alien_nac") String alien_nac,
            @Field("alien_status") String alien_status

    );


    @FormUrlEncoded
    @POST("login")
    Call<Login>logAlien(
            @Field("alien_correo") String alien_correo,
            @Field("alien_contrasenia") String alien_contrasenia
    );

}
