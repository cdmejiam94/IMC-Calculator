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
import com.preeliminatorylabs.calculadoradeimc.controller.IMCController
import com.preeliminatorylabs.calculadoradeimc.model.Persona
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentIMCViewModel
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentIMCViewModelFactory

class FragmentIMC : Fragment() {

    private lateinit var imcViewModel: FragmentIMCViewModel

    private lateinit var btnCalculate : Button
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var gender: EditText
    private lateinit var weight: EditText
    private lateinit var height: EditText


    companion object {
        fun newInstance() : Fragment{
            return  FragmentIMC()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_imc, container, false)

        imcViewModel = ViewModelProviders.of(
            this,
            FragmentIMCViewModelFactory(IMCController())
        )[FragmentIMCViewModel::class.java]

        imcViewModel.persona.observe(viewLifecycleOwner, Observer {
            if (it!=null){
                Toast.makeText(root.context,it.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        btnCalculate = root.findViewById(R.id.btnCalculateIMC)
        name = root.findViewById(R.id.edtName)
        age = root.findViewById(R.id.edtAge)
        weight = root.findViewById(R.id.edtWeight)
        height = root.findViewById(R.id.edtHeight)
        gender = root.findViewById(R.id.edtGenre)

        btnCalculate.setOnClickListener { imcViewModel.calculateIMC(
            Persona(name.text.toString(),
                age.text.toString().toInt(),
                gender.text[0],
                weight.text.toString().toDouble(),
                height.text.toString().toDouble()
                )
            )

            imcViewModel.addItemData(AppData("IMC",name.text.toString(),
                "",
                age.text.toString().toInt(),
                gender.text[0],
                weight.text.toString().toDouble(),
                height.text.toString().toDouble()
            ),activity?.applicationContext!!)
        }

        return root
    }
}