package com.preeliminatorylabs.calculadoradeimc.persistance.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AppData.TABLE_NAME)
data class AppData(
    @ColumnInfo(name = "type") val type : String = "",
    @ColumnInfo(name = "first_name") val first_name : String = "",
    @ColumnInfo(name = "last_name") val last_name : String = "",
    @ColumnInfo(name = "age") val age : Int = 0,
    @ColumnInfo(name = "gender") val gender : Char = 'x',
    @ColumnInfo(name = "weight") val weight : Double = 0.0,
    @ColumnInfo(name = "height") val height : Double = 0.0,
    @ColumnInfo(name = "user_name") val user_name : String = "",
    @ColumnInfo(name = "email") val email : String = "",
    @ColumnInfo(name = "password") val password : String = "",
    @ColumnInfo(name = "id_client") val id_client : Int = 0,
    @ColumnInfo(name = "geb") val geb : Double = 0.0
) {
    companion object{
        const val TABLE_NAME = "backlog"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "log_id")
    var log_id: Int = 0

}