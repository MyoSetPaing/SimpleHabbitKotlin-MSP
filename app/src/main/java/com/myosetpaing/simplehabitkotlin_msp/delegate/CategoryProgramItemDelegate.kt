package com.myosetpaing.simplehabitkotlin_msp.delegate

import com.myosetpaing.simplehabitkotlin_msp.data.vos.ProgramVO

interface CategoryProgramItemDelegate{
    fun  onTapCategoryProgram(program: ProgramVO,itemId: String,position: Int)
}