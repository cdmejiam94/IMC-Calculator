package com.preeliminatorylabs.calculadoradeimc.service.request

import com.google.gson.annotations.SerializedName

class ClientsRegisterRequest (

    @SerializedName("Nombre") val name : String = "",
    @SerializedName("Apellidos") val last_name : String = "",
    @SerializedName("Nombre_Usuario") val user_name : String = "",
    @SerializedName("Correo_Electronico") val email : String = "",
    @SerializedName("Contraseña") val password : String = ""

    )