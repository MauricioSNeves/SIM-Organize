package com.example.simmobile.interfaces

import com.example.simmobile.data.RegisterData
import com.example.simmobile.data.Tarefa
import retrofit2.Call
import retrofit2.http.*

interface OpenAplication {

    //cadastro
    @POST("/usuarios")
    fun postUser(@Body newTarget: RegisterData) : Call<Void>


}