package com.preeliminatorylabs.calculadoradeimc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.preeliminatorylabs.calculadoradeimc.controller.IMCController

class FragmentIMCViewModelFactory(private val controller: IMCController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentIMCViewModel(controller) as T
    }
}