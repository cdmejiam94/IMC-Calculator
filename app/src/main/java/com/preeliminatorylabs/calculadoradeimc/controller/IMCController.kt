package com.preeliminatorylabs.calculadoradeimc.controller

import com.preeliminatorylabs.calculadoradeimc.model.IMC_Table
import com.preeliminatorylabs.calculadoradeimc.model.Persona

class IMCController {

    fun getResults(persona: Persona) : Persona {
        persona.setAdult(getAdultStatus(persona))
        persona.setStatusIMC(getIMCStatus(persona))
        return persona
    }

    fun getAdultStatus(persona: Persona) : String {
        if (persona.esMayorDeEdad()){
            return "Es mayor de edad"
        } else {
            return "No es mayor de edad"
        }
    }

    fun getIMCStatus(persona: Persona) : String{
        when(persona.calcularIMC()){
            -1 -> {
                return IMC_Table.FALTA_PESO.toString()
            }
            0 -> {
                return IMC_Table.PESO_NORMAL.toString()
            }
            else -> {
                return IMC_Table.SOBREPESO.toString()
            }
        }
    }
}