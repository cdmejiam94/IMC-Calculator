package com.preeliminatorylabs.calculadoradeimc.repository

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.preeliminatorylabs.calculadoradeimc.persistance.AppDataDataBase
import com.preeliminatorylabs.calculadoradeimc.persistance.dao.AppDataDao
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData

class AppDataRepository(context: Context) {
    private val appDataDao: AppDataDao? = AppDataDataBase.getInstance(context)?.appDataDao()

    fun insert(appData: AppData){
        if (appDataDao != null) InsertAsyncTask(appDataDao).execute(appData)
    }

    fun getOrderedBacklogLiveData(): LiveData<List<AppData>> {
        return appDataDao?.getOrderedBacklogLiveData() ?: MutableLiveData<List<AppData>>()
    }

    private class InsertAsyncTask(private val appDataDao: AppDataDao) :
        AsyncTask<AppData, Void, Void>(){
        override fun doInBackground(vararg contacts: AppData?): Void? {
            for(contact in contacts) {
                if (contact != null) appDataDao.insert(contact)
            }
            return null
        }
    }
}