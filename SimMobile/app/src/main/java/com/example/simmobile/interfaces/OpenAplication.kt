package com.example.simmobile.interfaces

import com.example.simmobile.data.RegisterData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAplication {

    //cadastro
    @POST("/usuarios")
    fun postUser(@Body newTarget: RegisterData) : Call<Void>



}