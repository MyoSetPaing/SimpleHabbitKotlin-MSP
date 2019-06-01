package com.myosetpaing.simplehabitkotlin_msp.mvp.views

import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO

interface MainView: BaseView{
    fun showCurrentProgram(currentProgram: CurrentProgramVO)
    fun showFailMessage(message: String)
    fun showNoDataMessage(message: String)
    fun showDetail(type: String, position: Int = 0, itemId: String = "")
    fun showCategoryPrograms(categoryPrograms: List<CategoryProgramVO>)
    fun showTopic(topicList: List<TopicVO>)
}