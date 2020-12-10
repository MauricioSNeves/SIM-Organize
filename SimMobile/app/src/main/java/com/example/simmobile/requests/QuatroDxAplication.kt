package com.example.simmobile.requests

import com.example.simmobile.models.*
import com.example.simmobile.models.responses.AllDxResponse
import com.example.simmobile.models.responses.QuatroDxResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface QuatroDxAplication {

    //4DX
    @POST("/metodosdxs/4dx")
    fun postDx(@Body newTarget: DxData) : Call<QuatroDxResponse>

    @GET("metodosdxs/importar")
    fun exportDx() : Call<Void>

    @GET("metodosdxs")
    fun getDxs() : Call<List<AllDxResponse>>

    @GET("/metodosdxs/4dx/{id}")
    fun getDxById(@Path("idDx") idDx: Int?) : Call<QuatroDxResponse>

    //MD's
    @POST("/metodosdxs/4dx/{id}/mdUm")
    fun postMdUm(@Path("id") id: Int?, @Body newTarget: CriaMdUmData) : Call<Void>

    @POST("/metodosdxs/4dx/{id}/mdDois")
    fun postMdDois(@Path("id") id: Int?, @Body newTarget: CriaMdDoisData) : Call<Void>

    //tasks
    @POST("metodosdxs/4dx/{idDx}/mdUm/{idMd}")
    fun postTasksMdUm(@Path("idDX") idDX:Int,@Path("idMd") idMd:Int ,@Body newTarget: CriaMdUmTask) : Call<Void>

    @POST("metodosdxs/4dx/{idDx}/mdUm/{idMd}")
    fun postTasksMdDois(@Path("idDX") idDX: Int?, @Path("idMd") idMd:Int, @Body newTarget: CriaMdDoisTasks) : Call<Void>

    @GET("metodosdxs/tarefas/{id}")
    fun getTasks() : Call<TasksDxData>

}