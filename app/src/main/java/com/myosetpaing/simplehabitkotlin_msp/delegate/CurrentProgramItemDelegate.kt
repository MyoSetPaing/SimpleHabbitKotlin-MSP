package com.myosetpaing.simplehabitkotlin_msp.delegate

import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO

interface CurrentProgramItemDelegate {

    fun onTapCurrentProgram(currentProgram: CurrentProgramVO)
}
