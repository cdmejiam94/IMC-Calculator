package com.preeliminatorylabs.calculadoradeimc.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.preeliminatorylabs.calculadoradeimc.persistance.AppDataDataBase
import com.preeliminatorylabs.calculadoradeimc.persistance.dao.AppDataDao
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.view.fragment.FragmentBacklog

class AppDataRepository(fragment: FragmentBacklog) {
    private val appDataDao: AppDataDao? = AppDataDataBase.getInstance(fragment)?.appDataDao()

    fun insert(appData: AppData){
        if (appDataDao != null) InsertAsyncTask(appDataDao).execute(appData)
    }

    fun getOrderedBacklogLiveData(): LiveData<List<AppData>> {
        //?: es como si fuera un if
        return appDataDao?.getOrderedBacklogLiveData() ?: MutableLiveData<List<AppData>>()
    }

    private class InsertAsyncTask(private val appDataDao: AppDataDao) :
        AsyncTask<AppData, Void, Void>(){
        //Procesos en segundo plano
        override fun doInBackground(vararg contacts: AppData?): Void? {
            for(contact in contacts) {
                if (contact != null) appDataDao.insert(contact)
            }
            return null
        }
    }
}