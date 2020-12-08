package com.example.simmobile.requests

import com.example.simmobile.models.DxData
import com.example.simmobile.models.CriaMdsData
import com.example.simmobile.models.TasksDxData
import com.example.simmobile.models.responses.AllDxResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface QuatroDxAplication {

    //4DX
    @POST("/metodosdxs/4dx")
    fun postDx(@Body newTarget: DxData) : Call<Void>

    @GET("metodosdxs/importar")
    fun exportDx() : Call<Void>

    @GET("metodosdxs")
    fun getDxs() : Call<List<AllDxResponse>>

    //MD's
    @POST("/metodosdxs/4dx/{id}/mdUm")
    fun postMdUm(@Path("id") id:Int, @Body newTarget: CriaMdsData) : Call<Void>

    @POST("/metodosdxs/4dx/{id}/mdDois")
    fun postMdDois(@Path("id") id:Int,@Body newTarget: CriaMdsData) : Call<Void>

    //tasks
    @POST("metodosdxs/4dx/{idDx}/mdUm/{idMd}")
    fun postTasks(@Path("idDX") idDX:Int,@Path("idMd") idMd:Integer ,@Body newTarget: CriaMdsData) : Call<Void>

    @GET("metodosdxs/tarefas/{id}")
    fun getTasks() : Call<TasksDxData>

}