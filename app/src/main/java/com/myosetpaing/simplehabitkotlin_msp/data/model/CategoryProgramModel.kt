package com.myosetpaing.simplehabitkotlin_msp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO

interface CategoryProgramModel{
    fun getCategoryProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<CategoryProgramVO>>
    fun getCategoryProgramById(categoryId: String): LiveData<CategoryProgramVO>
}