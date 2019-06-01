package com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.impl

import androidx.lifecycle.ViewModel
import com.myosetpaing.simplehabitkotlin_msp.mvp.views.BaseView


abstract class BasePresenterImpl<V : BaseView> : ViewModel() {

    protected lateinit var mView: V

    fun initPresenter(view: V) {
        mView = view
    }
}