package com.myosetpaing.simplehabitkotlin_msp.mvp.presenters

import com.myosetpaing.simplehabitkotlin_msp.activities.BaseActivity

interface DetailPresenter{
    fun onUIReady(activity: BaseActivity, type: String, categoryId: String = "")

}