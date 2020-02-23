package com.preeliminatorylabs.calculadoradeimc.controller

import com.preeliminatorylabs.calculadoradeimc.model.IMC_Table
import com.preeliminatorylabs.calculadoradeimc.model.Persona

class IMCController {

    fun getResults(persona: Persona) : Persona {
        if (persona.esMayorDeEdad()){
            persona.setAdult("Es mayor de edad")
        } else {
            persona.setAdult("No es mayor de edad")
        }

        when(persona.calcularIMC()){
            -1 -> {
                persona.setStatusIMC(IMC_Table.FALTA_PESO.toString())
            }
            0 -> {
                persona.setStatusIMC(IMC_Table.PESO_NORMAL.toString())
            }
            else -> {
                persona.setStatusIMC(IMC_Table.SOBREPESO.toString())
            }
        }

        return persona

    }
}