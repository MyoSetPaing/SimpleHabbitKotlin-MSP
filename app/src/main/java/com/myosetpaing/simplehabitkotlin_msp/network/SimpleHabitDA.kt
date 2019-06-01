package com.myosetpaing.simplehabitkotlin_msp.network

import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramDelegate
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramDelegate
import com.myosetpaing.simplehabitkotlin_msp.delegate.TopicDelegate

interface SimpleHabitDA {
    companion object {
        val ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"
    }
    fun getCurrentProgram(token: String, page: Int, delegate: CurrentProgramDelegate)
    fun getTopics(token: String, page: Int, delegate: TopicDelegate)
    fun getCategoriesPrograms(token: String, page: Int, delegate: CategoryProgramDelegate)
}