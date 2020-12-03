package com.example.simmobile.requests

import com.example.simmobile.models.Tarefa
import retrofit2.Call
import retrofit2.http.*

interface CheckListApi {
    @GET("/checklist/tarefa")
    fun getTarefas(): Call<List<Tarefa>>

    @GET("/checklist/tarefa/{id}")
    fun getTarefa(@Path("id") id:Integer): Call<Tarefa>


    @DELETE("/checklist/tarefa/{id}")
    fun deleteTarefa(@Path("id") id:Integer): Call<Void>
    // Call<Void> Indica que este Endpoint não vai retornar nada

    @POST("/checklist/tarefa")
    fun postTarefa(@Body novaTarefa: Tarefa): Call<Void>

    @PUT("/checklist/tarefa/{id}")
    fun outTarefa(@Body alteraTarefa: Tarefa): Call<Tarefa>

}