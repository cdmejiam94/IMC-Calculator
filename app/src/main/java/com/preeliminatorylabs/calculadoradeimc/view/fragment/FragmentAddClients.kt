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
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.service.request.ClientsRegisterRequest
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentAddClientsViewModel
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentAddClientsViewModelFactory

class FragmentAddClients : Fragment() {

    private lateinit var addClientViewModel: FragmentAddClientsViewModel

    private lateinit var btnPost : Button
    private lateinit var first_name: EditText
    private lateinit var last_name: EditText
    private lateinit var user_name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText

    companion object {
        fun newInstance() : Fragment {
            return  FragmentAddClients()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_add_clients_form, container, false)

        btnPost = root.findViewById(R.id.btnPostClient)
        first_name = root.findViewById(R.id.edtRegisterName)
        last_name = root.findViewById(R.id.edtRegisterLastName)
        user_name = root.findViewById(R.id.edtUserName)
        email = root.findViewById(R.id.edtEmail)
        password = root.findViewById(R.id.edtPassword)

        addClientViewModel = ViewModelProviders.of(
            this,
            FragmentAddClientsViewModelFactory(ApiController())
        )[FragmentAddClientsViewModel::class.java]

        addClientViewModel.results.observe(viewLifecycleOwner, Observer {
            if (!it){
                Toast.makeText(root.context,"Ocurrio un error, Consulte al administrador para más información",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(root.context,"Registro exitoso",
                    Toast.LENGTH_SHORT).show()
            }
        })

        btnPost.setOnClickListener { addClientViewModel.postClients(
                ClientsRegisterRequest(first_name.text.toString(),
                    last_name.text.toString(),
                    user_name.text.toString(),
                    email.text.toString(),
                    password.text.toString()
                )
            )

            addClientViewModel.addItemData(
                AppData("POST",first_name.text.toString(),
                    last_name.text.toString(),
                    0,'x',0.0,0.0,
                    user_name.text.toString(),email.text.toString(),
                    password.text.toString()
                ),activity?.applicationContext!!)

        }
        return root
    }
}