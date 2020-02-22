package com.preeliminatorylabs.calculadoradeimc.controller

import com.preeliminatorylabs.calculadoradeimc.model.ApiResponse
import com.preeliminatorylabs.calculadoradeimc.model.Client
import com.preeliminatorylabs.calculadoradeimc.service.ApiClient
import io.reactivex.Single

class ApiController {

    val service = ApiClient().initRetrofit()

    fun getClientsApi(): Single<List<Client>> {
        return service.getClients().map { it }
    }
}