package com.example.simmobile.requests

import com.example.simmobile.models.Tarefa
import retrofit2.Call
import retrofit2.http.*

interface CheckListApi {
    @GET("checklists")
    fun listarTarefas(): Call<List<Tarefa>>

    @GET("checklists/tarefa/{id}")
    fun getTarefa(@Path("id") id:Int): Call<Tarefa>


    @DELETE("checklists/tarefa/{id}")
    fun deleteTarefa(@Path("id") id:Int): Call<Void>
    // Call<Void> Indica que este Endpoint não vai retornar nada

    @POST("checklists/tarefa")
    fun cadastrarTarefas(@Body novaTarefa: Tarefa): Call<Void>

    @PUT("checklists/tarefa/{id}")
    fun outTarefa(@Body alteraTarefa: Tarefa): Call<Tarefa>

}