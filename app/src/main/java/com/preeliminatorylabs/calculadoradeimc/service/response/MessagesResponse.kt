package com.preeliminatorylabs.calculadoradeimc.service.response

import com.google.gson.annotations.SerializedName

data class MessagesResponse (
    @SerializedName("Cve_Mensaje") val message_id : Int = 0,
    @SerializedName("Mensaje") val message : String = ""
)