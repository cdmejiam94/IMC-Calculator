package com.preeliminatorylabs.calculadoradeimc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController

class FragmentUpdateClientsViewModelFactory(private val controller: ApiController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentUpdateClientsViewModel(controller) as T
    }
}