package com.myosetpaing.simplehabitkotlin_msp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.simplehabitkotlin_msp.data.vos.ProgramVO

class ProgramListConverter {

    @TypeConverter
    fun fromListToJson(list: List<ProgramVO>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJsonToList(data: String): List<ProgramVO>? {
        val typelist = object : TypeToken<List<ProgramVO>>() {

        }.type
        return Gson().fromJson<List<ProgramVO>>(data, typelist)
    }
}