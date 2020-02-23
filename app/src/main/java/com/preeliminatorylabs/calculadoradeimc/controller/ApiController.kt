package com.preeliminatorylabs.calculadoradeimc.controller

import android.util.Log
import com.preeliminatorylabs.calculadoradeimc.model.Client
import com.preeliminatorylabs.calculadoradeimc.service.ApiClient
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsRegisterRequest
import io.reactivex.Single
import retrofit2.HttpException


class ApiController {

    val service = ApiClient().initRetrofit()

    fun getClientsApi(): Single<List<Client>> {
        return service.getClients().map { it }
    }

    fun postClientApi(clientsRegisterRequest: ClientsRegisterRequest): Single<Boolean> {
        return service.postClients(clientsRegisterRequest).map {
            true
        }.onErrorReturn {
            val error: HttpException = it as HttpException
            Log.e("Error","HTTP: " + error.code() + " " + error.message() +
                    " Body:" + (error.response().errorBody()?.string() ?: ""))
            false
        }
    }
}