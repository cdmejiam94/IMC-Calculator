package com.preeliminatorylabs.calculadoradeimc.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.repository.AppDataRepository
import com.preeliminatorylabs.calculadoradeimc.view.fragment.FragmentBacklog

class FragmentBacklogViewModel (fragmentBacklog: FragmentBacklog) : ViewModel() {

    private val repository = AppDataRepository(fragmentBacklog)

    val appData = repository.getOrderedBacklogLiveData()

    fun saveData(appData: AppData){
        repository.insert(appData)
    }
}