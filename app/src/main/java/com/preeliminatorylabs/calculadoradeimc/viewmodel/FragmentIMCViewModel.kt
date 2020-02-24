package com.preeliminatorylabs.calculadoradeimc.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.calculadoradeimc.controller.IMCController
import com.preeliminatorylabs.calculadoradeimc.model.Persona
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.repository.AppDataRepository

class FragmentIMCViewModel(val imcController : IMCController) : ViewModel() {

    val persona : MutableLiveData<Persona> = MutableLiveData()

    fun addItemData(appData: AppData, context: Context){
        val repository = AppDataRepository(context)
        repository.insert(appData)
    }

    fun calculateIMC(persona: Persona){
        this.persona.value = imcController.getResults(persona)
    }

}