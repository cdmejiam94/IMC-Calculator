package com.preeliminatorylabs.calculadoradeimc.service.request

import com.google.gson.annotations.SerializedName

class ClientsUpdateRequest (
    @SerializedName("Edad") val age : Int = 0,
    @SerializedName("Estatura") val height : Double = 0.0,
    @SerializedName("Peso") val weight : Double = 0.0,
    @SerializedName("GEB") val geb : Double = 0.0
    )