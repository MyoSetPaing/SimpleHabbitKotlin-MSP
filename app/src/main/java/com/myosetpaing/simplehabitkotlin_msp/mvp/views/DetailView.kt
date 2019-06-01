package com.myosetpaing.simplehabitkotlin_msp.mvp.views

import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO

interface DetailView: BaseView{

    fun showCurrentProgramDetail(currentProgram: CurrentProgramVO)
    fun showCategoryProgramDetail(categoryProgram: CategoryProgramVO)
    fun showNoData(message: String)


}