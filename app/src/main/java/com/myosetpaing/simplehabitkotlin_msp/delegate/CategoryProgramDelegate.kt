package com.myosetpaing.simplehabitkotlin_msp.delegate

import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO

interface CategoryProgramDelegate{
    fun onSuccess(categoryProgramVOList: List<CategoryProgramVO>)
    fun onFail(message: String)

}