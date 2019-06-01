package com.myosetpaing.simplehabitkotlin_msp.data.model

import android.content.Context
import com.myosetpaing.simplehabitkotlin_msp.network.RetrofitDA
import com.myosetpaing.simplehabitkotlin_msp.network.SimpleHabitDA
import com.myosetpaing.simplehabitkotlin_msp.persistence.SimpleHabitDB

abstract class BaseModel{

    val mDataAgent: SimpleHabitDA = RetrofitDA
    protected lateinit var mDataBase: SimpleHabitDB

    fun initDataBase(context: Context){
        mDataBase = SimpleHabitDB.getDatabase(context)
    }


}