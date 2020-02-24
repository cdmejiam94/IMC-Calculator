package com.preeliminatorylabs.calculadoradeimc.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.repository.AppDataRepository

class FragmentBacklogViewModel : ViewModel() {

    val getData : MutableLiveData<List<AppData>> = MutableLiveData()

    fun addItemData(appData: AppData, context: Context){
        val repository = AppDataRepository(context)
        repository.insert(appData)
    }

    fun getDataRepository(context: Context, lifecycleOwner: LifecycleOwner){
        val repository = AppDataRepository(context)
        repository.getOrderedBacklogLiveData().observe(lifecycleOwner, Observer {
            getData.value = it
        })
    }
}