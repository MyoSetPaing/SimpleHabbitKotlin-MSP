package com.myosetpaing.simplehabitkotlin_msp

import android.app.Application
import com.myosetpaing.simplehabitkotlin_msp.data.model.CategoryProgramModelImpl
import com.myosetpaing.simplehabitkotlin_msp.data.model.CurrentProgramModelImpl
import com.myosetpaing.simplehabitkotlin_msp.data.model.TopicModelImpl

class SimpleHabitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CurrentProgramModelImpl.initDataBase(applicationContext)
        CategoryProgramModelImpl.initDataBase(applicationContext)
        TopicModelImpl.initDataBase(applicationContext)
    }
}