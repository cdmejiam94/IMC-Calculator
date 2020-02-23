package com.preeliminatorylabs.calculadoradeimc.model

import kotlin.random.Random

class Persona (
    private var nombre : String = "",
    private var edad : Int = 0,
    private var sexo : Char = 'H',
    private var peso : Double = 0.0,
    private var altura : Double = 0.0
) {
    private var imc : Double = 0.0

    private var NSS : CharArray = CharArray(8)

    private var adult : String = ""

    private var statusIMC : String = ""

    fun setAdult(adult: String) {
        this.adult = adult
    }

    fun setStatusIMC(statusIMC: String) {
        this.statusIMC = statusIMC
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    private fun setEdad(edad: Int) {
        this.edad = edad
    }

    fun setSexo(sexo: Char) {
        this.sexo = sexo
    }

    fun setPeso(peso: Double) {
        this.peso = peso
    }

    fun setAltura(altura: Double) {
        this.altura = altura
    }

    fun setImc(imc: Double) {
        this.imc = imc
    }

    fun calcularIMC() : Int{
        imc = (peso/Math.pow(altura,2.0))

        if (sexo == 'H'){
            when (imc){
                in 20.0..25.0 -> {
                    return 0
                }
                in 0.0..20.0 -> {
                    return -1
                } else -> return 1
            }
        } else {
            when (imc){
                in 19.0..24.0 -> {
                    return 0
                }
                in 0.0..19.0 -> {
                    return -1
                } else -> return 1
            }
        }
        generarNSS()
    }

    fun esMayorDeEdad() : Boolean {
        return edad >= 18
    }

    fun comprobarSexo() : Boolean {
        return sexo == 'M' || sexo == 'H'
    }

    override fun toString(): String {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nNSS: " + NSS.toString() + "\nSexo: " +
                sexo + "\nPeso: " + peso + "\nAltura: " + altura + "\n " + adult + "\nIMC: " + statusIMC
    }

    private fun generarNSS(){
        generateCharSequence()
        generateIntSequence()
    }

    private fun generateCharSequence(){
        for (i in 0..3) {
            NSS[i] = Random.nextInt(65,122).toChar()
        }
    }

    private fun generateIntSequence(){
        for (i in 4..7) {
            NSS[i] = Random.nextInt(48,57).toChar()
        }
    }

}