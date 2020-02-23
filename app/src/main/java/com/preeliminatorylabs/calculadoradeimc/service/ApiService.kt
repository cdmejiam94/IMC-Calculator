package com.preeliminatorylabs.calculadoradeimc.service

import com.preeliminatorylabs.calculadoradeimc.model.Client
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsRegisterRequest
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsUpdateRequest
import com.preeliminatorylabs.calculadoradeimc.service.response.MessagesResponse
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    @GET("NutriNET/Cliente")
    fun getClients(): Single<List<Client>>

    @POST("NutriNET/Cliente")
    fun postClients(@Body clientsRegisterRequest: ClientsRegisterRequest): Single<List<MessagesResponse>>

    @PUT("NutriNET/Cliente/{id}")
    fun updateClients(
        @Path("id") id : Int = 0,
        @Body clientsUpdateRequest: ClientsUpdateRequest
    ): Single<List<MessagesResponse>>

}