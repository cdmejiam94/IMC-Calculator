package com.preeliminatorylabs.calculadoradeimc.model

import com.google.gson.annotations.SerializedName

data class Client (
    @SerializedName("Cliente_ID") val client_id : Int = 0,
    @SerializedName("Nombre_Usuario") val user_name : String = "",
    @SerializedName("Contraseña") val password : String = "",
    @SerializedName("Nombre") val name : String = "",
    @SerializedName("Apellidos") val last_name : String = "",
    @SerializedName("Correo_Electronico") val email : String = "",
    @SerializedName("Edad") val age : Int = 0,
    @SerializedName("Estatura") val height : Double = 0.0,
    @SerializedName("Peso") val weight : Double = 0.0,
    @SerializedName("Genero_ID") val gender : Int = 0,
    @SerializedName("Actividad_Fisica_ID") val physical_activity_id : Int = 0,
    @SerializedName("Dieta_ID") val diet_id : Int = 0,
    @SerializedName("IMC") val imc : Double = 0.0,
    @SerializedName("GEB") val geb : Double = 0.0,
    @SerializedName("ETA") val eta : Double = 0.0,
    @SerializedName("Peso_Maximo") val min_weight : Double = 0.0,
    @SerializedName("Peso_Minimo") val max_weight : Double = 0.0,
    @SerializedName("AF") val af : Double = 0.0,
    @SerializedName("Gasto_Energetico_Total") val energetic_expense : Double = 0.0,
    @SerializedName("Tipo_Cliente_ID") val client_type_id : Int = 0,
    @SerializedName("Activo") val active : Boolean = true,
    @SerializedName("Orden") val order : Int = 0,
    @SerializedName("Fecha_Creacion") val created_at : String = "",
    @SerializedName("Fecha_Actualizacion") val updated_at : String = "",
    @SerializedName("Usuario_ID") val user_id : Int = 0,
    @SerializedName("Visible") val visibility : Boolean = true,
    @SerializedName("De_Sistema") val from_system : Boolean = true
)