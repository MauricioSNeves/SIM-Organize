package com.example.simmobile.configurations

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientRetrofit {

    fun criarCliente(token:String):Retrofit{

        val httpClient = OkHttpClient.Builder()

        val interceptor = Interceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .header("Authorization", "Bearear ${token}")
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)
        }

        httpClient.addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://192.168.0.104:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()


            return retrofit;

    }
}