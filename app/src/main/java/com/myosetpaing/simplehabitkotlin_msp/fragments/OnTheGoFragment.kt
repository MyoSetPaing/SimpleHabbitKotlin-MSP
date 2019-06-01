package com.myosetpaing.simplehabitkotlin_msp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R

class OnTheGoFragment : BaseFragment() {

    companion object {
        fun newInstance() = OnTheGoFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_on_the_go, container, false)

    }
}