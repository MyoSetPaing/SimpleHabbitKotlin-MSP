package com.myosetpaing.simplehabitkotlin_msp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramDelegate
import com.myosetpaing.simplehabitkotlin_msp.network.SimpleHabitDA

object CurrentProgramModelImpl : BaseModel(), CurrentProgramModel {


    override fun getCurrentProgram(): LiveData<CurrentProgramVO> {
        return mDataBase.getCurrentProgramDao.getCurrentProgram()
    }

    override fun loadCurrentProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<CurrentProgramVO> {

        if(mDataBase.isCurrentProgramEmpty || isForce){

            mDataAgent.getCurrentProgram(SimpleHabitDA.ACCESS_TOKEN,1,object : CurrentProgramDelegate{
                override fun onSuccess(currentProgramList: CurrentProgramVO) {
                    mDataBase.getCurrentProgramDao.insertCurrentProgram(currentProgramList)
                }

                override fun onFail(msg: String?) {
                    networkFailure(msg!!)
                }

            })

        }
        return mDataBase.getCurrentProgramDao.getCurrentProgram()
    }


}