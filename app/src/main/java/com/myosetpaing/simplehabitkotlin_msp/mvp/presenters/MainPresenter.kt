package com.myosetpaing.simplehabitkotlin_msp.mvp.presenters

import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramItemDelegate
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramItemDelegate
import com.myosetpaing.simplehabitkotlin_msp.fragments.BaseFragment

interface MainPresenter: CurrentProgramItemDelegate, CategoryProgramItemDelegate {

    fun onUIReady(activity: BaseFragment)
    fun onRefreshPage(activity: BaseFragment)
}