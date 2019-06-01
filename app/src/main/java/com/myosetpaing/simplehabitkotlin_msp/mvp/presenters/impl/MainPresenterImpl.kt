package com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.impl


import androidx.lifecycle.Observer
import com.myosetpaing.simplehabitkotlin_msp.data.model.*
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.ProgramVO
import com.myosetpaing.simplehabitkotlin_msp.fragments.BaseFragment
import com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.MainPresenter
import com.myosetpaing.simplehabitkotlin_msp.mvp.views.MainView

class MainPresenterImpl : BasePresenterImpl<MainView>(), MainPresenter {


    private val NAME_CURRENT = "current"
    private val NAME_CATEGORY_PROGRAM = "category_program"
    private val currentProgramModel: CurrentProgramModel = CurrentProgramModelImpl
    private val categoryProgramModel: CategoryProgramModel = CategoryProgramModelImpl
    private val topicModel: TopicModel = TopicModelImpl

    override fun onUIReady(activity: BaseFragment) {

        currentProgramModel.loadCurrentProgram(false) {
            mView.showFailMessage(it)
        }.observe(activity, Observer {
            if (it != null) {
                mView.showCurrentProgram(it)
            } else {
                mView.showNoDataMessage("")
            }
        })

        categoryProgramModel.getCategoryProgram(false) {
            mView.showFailMessage(it)
        }.observe(activity, Observer {
            if (it != null) {
                mView.showCategoryPrograms(it)
            } else {
                mView.showNoDataMessage(")")
            }
        })

        topicModel.getTopic(false){
            mView.showFailMessage(it)
        }.observe(activity, Observer {
            if(it != null){
                mView.showTopic(it)
            }else{
                mView.showNoDataMessage("")
            }
        })

    }

    override fun onRefreshPage(activity: BaseFragment) {
        currentProgramModel.loadCurrentProgram(true) {

            mView.showFailMessage(it)

        }.observe(activity, Observer {

            if (it != null) {
                mView.showCurrentProgram(it)
            } else {
                mView.showNoDataMessage("No Current Program in DB.")
            }

        })

        categoryProgramModel.getCategoryProgram(false) {
            mView.showFailMessage(it)
        }.observe(activity, Observer {
            if (it != null) {
                mView.showCategoryPrograms(it)
            } else {
                mView.showNoDataMessage(")")
            }
        })
    }

    override fun onTapCurrentProgram(currentProgram: CurrentProgramVO) {
        mView.showDetail(NAME_CURRENT)
    }

    override fun onTapCategoryProgram(program: ProgramVO, itemId: String, position: Int) {
        mView.showDetail(NAME_CATEGORY_PROGRAM, position, itemId)
    }
}