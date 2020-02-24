package com.preeliminatorylabs.calculadoradeimc.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.calculadoradeimc.R
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.view.activity.MainActivity
import com.preeliminatorylabs.calculadoradeimc.view.adapter.AppDataAdapter
import com.preeliminatorylabs.calculadoradeimc.view.adapter.ClientDataAdapter
import com.preeliminatorylabs.calculadoradeimc.viewmodel.FragmentBacklogViewModel

class FragmentBacklog : Fragment() {

    private lateinit var backlogViewModel: FragmentBacklogViewModel

    private lateinit var backlogRecyclerView: RecyclerView

    companion object {
        fun newInstance() : Fragment {
            return  FragmentBacklog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_backlog, container, false)

        backlogRecyclerView = root.findViewById(R.id.recyclerBacklog)

        backlogRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,false)

        activity?.let {
            backlogViewModel = ViewModelProviders.of(it).get(FragmentBacklogViewModel::class.java)
        }

        getData()

        backlogViewModel.getDataRepository(activity?.applicationContext!!,viewLifecycleOwner)

        return root

    }

    fun addItemData(){
        backlogViewModel.addItemData(AppData("IMC","Carlos"),activity?.applicationContext!!)
    }

    fun getData(){
        val observer = Observer<List<AppData>> {items ->
            val backlogAdapter = AppDataAdapter(items, activity as Context)
            backlogRecyclerView.adapter = backlogAdapter
        }
        backlogViewModel.getData.observe(viewLifecycleOwner, observer)
    }
}