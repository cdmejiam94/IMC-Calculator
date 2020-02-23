package com.preeliminatorylabs.calculadoradeimc.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.preeliminatorylabs.calculadoradeimc.R
import com.preeliminatorylabs.calculadoradeimc.controller.ApiController
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsUpdateRequest
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentUpdateClientsViewModel
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentUpdateClientsViewModelFactory

class FragmentUpdateClients : Fragment() {

    private lateinit var updateClientsViewModel: FragmentUpdateClientsViewModel

    private lateinit var btnUpdate : Button
    private lateinit var age: EditText
    private lateinit var heigth: EditText
    private lateinit var weight: EditText
    private lateinit var geb: EditText
    private lateinit var id: EditText

    companion object {
        fun newInstance() : Fragment {
            return  FragmentUpdateClients()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_update_clients_form, container, false)

        btnUpdate = root.findViewById(R.id.btnUpdateClient)
        id = root.findViewById(R.id.edtClientId)
        age = root.findViewById(R.id.edtUpdateAge)
        heigth = root.findViewById(R.id.edtUpdateHeight)
        weight = root.findViewById(R.id.edtUpdateWeight)
        geb = root.findViewById(R.id.edtUpdateGEB)

        updateClientsViewModel = ViewModelProviders.of(
            this,
            FragmentUpdateClientsViewModelFactory(ApiController())
        )[FragmentUpdateClientsViewModel::class.java]

        updateClientsViewModel.results.observe(viewLifecycleOwner, Observer {
            if (!it){
                Toast.makeText(root.context,"Ocurrio un error, Consulte al administrador para más información",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(root.context,"Se actualizó el registro",
                    Toast.LENGTH_SHORT).show()
            }
        })

        btnUpdate.setOnClickListener { updateClientsViewModel.updateClients(
            id.text.toString().toInt(),
            ClientsUpdateRequest (
                age.text.toString().toInt(),
                heigth.text.toString().toDouble(),
                weight.text.toString().toDouble(),
                geb.text.toString().toDouble()
            )
        ) }

        return root

    }
}