package com.preeliminatorylabs.calculadoradeimc.service

import com.preeliminatorylabs.calculadoradeimc.model.ApiResponse
import com.preeliminatorylabs.calculadoradeimc.model.Client
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET("NutriNET/Cliente")
    fun getClients(): Single<List<Client>>

    /*@POST("NutriNET/Cliente")
    fun getClients(): Single<List<Client>>

    @PUT("NutriNET/Cliente")
    fun getClients(): Single<List<Client>>*/

}