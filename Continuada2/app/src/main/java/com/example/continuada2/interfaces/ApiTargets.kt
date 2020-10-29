package com.example.continuada2.interfaces

import com.example.continuada2.data.Jobs
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiTargets {

    @GET("/Jobs")
    fun getJobs() : Call<List<Jobs>>

    @POST("/Jobs")
    fun postJobs(@Body newTarget:Jobs) : Call<Void>

}