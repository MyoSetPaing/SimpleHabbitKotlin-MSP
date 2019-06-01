package com.myosetpaing.simplehabitkotlin_msp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.myosetpaing.simplehabitkotlin_msp.fragments.OnTheGoFragment
import com.myosetpaing.simplehabitkotlin_msp.fragments.SeriesFragment
import com.myosetpaing.simplehabitkotlin_msp.fragments.TeachersFragment


class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OnTheGoFragment.newInstance()
            1 -> SeriesFragment.newInstance()
            else -> TeachersFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            "ON THE GO"
        } else if (position == 1) {
            "SERIES"
        } else {
            "TEACHERS"
        }
    }
}
