package com.myosetpaing.simplehabitkotlin_msp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramDelegate
import com.myosetpaing.simplehabitkotlin_msp.network.SimpleHabitDA

object CategoryProgramModelImpl : BaseModel(), CategoryProgramModel {


    override fun getCategoryProgram(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<CategoryProgramVO>> {

        if(mDataBase.isCategoryProgramsEmpty || isForce){
            mDataAgent.getCategoriesPrograms(SimpleHabitDA.ACCESS_TOKEN,1,object : CategoryProgramDelegate{
                override fun onSuccess(categoryProgramVOList: List<CategoryProgramVO>) {
                    mDataBase.getCategoryProgramDao.insertCategoryPrograms(categoryProgramVOList)
                }

                override fun onFail(message: String) {
                    networkFailure(message)
                }

            })
        }
        return mDataBase.getCategoryProgramDao.getCategoryProgram()
    }

    override fun getCategoryProgramById(categoryId: String): LiveData<CategoryProgramVO> {
        return mDataBase.getCategoryProgramDao.getCategoryProgramById(categoryId)

    }
}