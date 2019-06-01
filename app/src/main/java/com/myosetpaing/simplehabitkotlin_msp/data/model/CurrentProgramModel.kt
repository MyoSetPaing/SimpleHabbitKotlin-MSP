package com.myosetpaing.simplehabitkotlin_msp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramDelegate


interface CurrentProgramModel {
    fun getCurrentProgram(): LiveData<CurrentProgramVO>
    fun loadCurrentProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<CurrentProgramVO>

}

