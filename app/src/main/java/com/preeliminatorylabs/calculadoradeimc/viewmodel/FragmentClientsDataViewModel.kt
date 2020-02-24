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

    fun getClients(){

        compositeDisposable.add(
            controller.getClientsApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    results.value = items
                }, {
                    it.printStackTrace()
                })

        )
    }

    fun addItemData(appData: AppData, context: Context){
        val repository = AppDataRepository(context)
        repository.insert(appData)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}
