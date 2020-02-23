package com.preeliminatorylabs.calculadoradeimc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController
import com.preeliminatorylabs.calculadoradeimc.model.Client
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsUpdateRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentUpdateClientsViewModel(val controller: ApiController): ViewModel() {
    val compositeDisposable = CompositeDisposable()

    val results: MutableLiveData<Boolean> = MutableLiveData()

    fun updateClients(id: Int, clientsUpdateRequest: ClientsUpdateRequest){

        compositeDisposable.add(

            //Subscribe solo se hace en el viewmodel porque esta apegado al ciclo de vida
            controller.updateClientApi(id,clientsUpdateRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    results.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    fun addLog(listItems : List<Client>){

    }

    //Memory leaks
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}