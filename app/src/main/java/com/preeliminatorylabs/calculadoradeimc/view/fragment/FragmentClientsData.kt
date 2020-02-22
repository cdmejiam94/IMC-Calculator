package com.preeliminatorylabs.calculadoradeimc.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.preeliminatorylabs.calculadoradeimc.R

class FragmentClientsData : Fragment() {

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
        return root

    }
}