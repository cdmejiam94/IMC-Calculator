package com.preeliminatorylabs.calculadoradeimc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController

class FragmentClientsDataViewModelFactory(private val controller: ApiController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentClientsDataViewModel(controller) as T
    }
}