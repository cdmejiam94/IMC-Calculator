package com.preeliminatorylabs.calculadoradeimc.persistance

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.preeliminatorylabs.calculadoradeimc.persistance.dao.AppDataDao
import com.preeliminatorylabs.calculadoradeimc.persistance.entity.AppData
import com.preeliminatorylabs.calculadoradeimc.view.fragment.FragmentBacklog

@Database(entities = [AppData::class], version = 1)
abstract class AppDataDataBase : RoomDatabase() {

    abstract fun appDataDao() : AppDataDao

    companion object{
        private const val DATABASE_NAME = "score_database"
        @Volatile
        private var INSTANCE: AppDataDataBase? = null

        fun getInstance(context: FragmentBacklog): AppDataDataBase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.requireContext(),
                    AppDataDataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}