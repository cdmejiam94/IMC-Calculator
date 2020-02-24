package com.preeliminatorylabs.calculadoradeimc.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData

@Dao
interface AppDataDao {
    @Insert
    fun insert(appData: AppData)

    @Query("SELECT * FROM " + AppData.TABLE_NAME+ " ORDER BY type")
    fun getOrderedBacklogLiveData(): LiveData<List<AppData>>
}