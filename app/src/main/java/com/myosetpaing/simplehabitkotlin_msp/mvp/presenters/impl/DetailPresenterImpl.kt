package com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.impl

import androidx.lifecycle.Observer
import com.myosetpaing.simplehabitkotlin_msp.activities.BaseActivity
import com.myosetpaing.simplehabitkotlin_msp.activities.DetailActivity
import com.myosetpaing.simplehabitkotlin_msp.data.model.CategoryProgramModelImpl
import com.myosetpaing.simplehabitkotlin_msp.data.model.CategoryProgramModel
import com.myosetpaing.simplehabitkotlin_msp.data.model.CurrentProgramModel
import com.myosetpaing.simplehabitkotlin_msp.data.model.CurrentProgramModelImpl
import com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.DetailPresenter
import com.myosetpaing.simplehabitkotlin_msp.mvp.views.DetailView

class DetailPresenterImpl : BasePresenterImpl<DetailView>(), DetailPresenter {

    private val currentProgramModel: CurrentProgramModel = CurrentProgramModelImpl
    private val categoryProgramModel: CategoryProgramModel = CategoryProgramModelImpl

    override fun onUIReady(activity: BaseActivity, type: String, categoryId: String) {

        if (type == DetailActivity.NAME_CURRENT) {
            currentProgramModel.getCurrentProgram().observe(activity, Observer {
                mView.showCurrentProgramDetail(it)
            })
        } else if (type == DetailActivity.NAME_CATEGORY_PROGRAM) {
            categoryProgramModel.getCategoryProgramById(categoryId).observe(activity, Observer {
                mView.showCategoryProgramDetail(it)
            })

        }


    }

}