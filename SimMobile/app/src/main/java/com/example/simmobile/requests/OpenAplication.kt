package com.example.simmobile.requests

import com.example.simmobile.models.AuthData
import com.example.simmobile.models.LoginData
import com.example.simmobile.models.RegisterData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAplication {

    //cadastro
    @POST("usuarios")
    fun postUser(@Body newUser: RegisterData) : Call<Void>

    @POST("auth")
    fun postUserLogin(@Body newTarget: LoginData) : Call<AuthData>

}