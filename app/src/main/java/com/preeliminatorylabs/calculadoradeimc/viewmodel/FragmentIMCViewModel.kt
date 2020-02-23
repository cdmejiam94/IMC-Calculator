package com.preeliminatorylabs.calculadoradeimc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.calculadoradeimc.controller.IMCController
import com.preeliminatorylabs.calculadoradeimc.model.Persona

class FragmentIMCViewModel(val imcController : IMCController) : ViewModel() {

    var persona : MutableLiveData<Persona> = MutableLiveData()

    fun calculateIMC(persona: Persona){
        this.persona.value = imcController.getResults(persona)
    }

}