package com.preeliminatorylabs.calculadoradeimc.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController
import com.preeliminatorylabs.calculadoradeimc.model.Client
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.repository.AppDataRepository
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsRegisterRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentClientsDataViewModel(val controller: ApiController) :  ViewModel(){

    val compositeDisposable = CompositeDisposable()

    val results: MutableLiveData<List<Client>> = MutableLiveData()

    //Otro liveData

    fun getClients(){

        compositeDisposable.add(

            //Subscribe solo se hace en el viewmodel porque esta apegado al ciclo de vida
            controller.getClientsApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    results.value = items
                    //Llamar addLog
                }, {
                    it.printStackTrace()
                })

        )
    }

    fun addItemData(appData: AppData, context: Context){
        val repository = AppDataRepository(context)
        repository.insert(appData)
    }

    //Memory leaks
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}
