package com.myosetpaing.simplehabitkotlin_msp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.simplehabitkotlin_msp.data.vos.SessionVO

class SessionListConverter {

    @TypeConverter
    fun fromListToJson(sessionList: List<SessionVO>): String {
        return Gson().toJson(sessionList)
    }

    @TypeConverter
    fun fromJsonToList(sessions: String): List<SessionVO>? {

        val listType = object : TypeToken<List<SessionVO>>() {

        }.type

        return Gson().fromJson<List<SessionVO>>(sessions, listType)
    }
}