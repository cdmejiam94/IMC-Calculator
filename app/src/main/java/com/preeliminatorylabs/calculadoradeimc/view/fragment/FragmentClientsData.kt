package com.preeliminatorylabs.calculadoradeimc.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.calculadoradeimc.R
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController
import com.preeliminatorylabs.calculadoradeimc.view.adapter.ClientDataAdapter
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentClientsDataViewModel
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentClientsDataViewModelFactory

class FragmentClientsData : Fragment() {

    private lateinit var clientsDataViewModel: FragmentClientsDataViewModel

    private lateinit var clientsRecyclerView: RecyclerView

    companion object {
        fun newInstance() : Fragment {
            return  FragmentClientsData()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_clients_data, container, false)

        clientsRecyclerView = root.findViewById(R.id.recyclerClientsData)

        clientsRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)

        clientsDataViewModel = ViewModelProviders.of(
            this,
            FragmentClientsDataViewModelFactory(ApiController())
        )[FragmentClientsDataViewModel::class.java]

        clientsDataViewModel.results.observe(viewLifecycleOwner, Observer { items ->
            val clientsAdapter = ClientDataAdapter(items, activity as Context)
            clientsRecyclerView.adapter = clientsAdapter
            clientsDataViewModel.addLog(items)
        })

        clientsDataViewModel.getClients()

        return root

    }
}