package com.myosetpaing.simplehabitkotlin_msp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R

class TeachersFragment: BaseFragment(){

    companion object {
        fun newInstance() = TeachersFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_teachers,container,false)
    }
}