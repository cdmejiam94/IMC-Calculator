package com.preeliminatorylabs.calculadoradeimc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController
import com.preeliminatorylabs.calculadoradeimc.model.Client
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentClientsDataViewModel(val controller: ApiController) :  ViewModel(){

    val compositeDisposable = CompositeDisposable()

    val results: MutableLiveData<List<Client>> = MutableLiveData()

    fun getClients(){

        compositeDisposable.add(

            //Subscribe solo se hace en el viewmodel porque esta apegado al ciclo de vida
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

    //Memory leaks
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}
