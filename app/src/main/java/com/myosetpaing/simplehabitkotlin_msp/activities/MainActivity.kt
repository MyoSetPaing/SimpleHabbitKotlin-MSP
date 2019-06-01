package com.myosetpaing.simplehabitkotlin_msp.activities

import android.os.Bundle
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private  var mainViewPagerAdapter : MainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vpMain.adapter = mainViewPagerAdapter
        vpMain.currentItem = 1
        tlMain.setupWithViewPager(vpMain)

    }
}
