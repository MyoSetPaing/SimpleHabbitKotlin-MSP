package com.myosetpaing.simplehabitkotlin_msp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IntegerListConverter {

    @TypeConverter
    fun fromListToJson(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJsonToList(data: String): List<Int>? {
        val typelist = object : TypeToken<List<Int>>() {

        }.type

        return Gson().fromJson<List<Int>>(data, typelist)
    }
}
