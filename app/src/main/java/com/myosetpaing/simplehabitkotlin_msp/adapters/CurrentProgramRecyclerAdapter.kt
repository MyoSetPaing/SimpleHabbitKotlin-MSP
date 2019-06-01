package com.myosetpaing.simplehabitkotlin_msp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramItemDelegate
import com.myosetpaing.simplehabitkotlin_msp.views.holders.CurrentProgramViewHolder

class CurrentProgramRecyclerAdapter(val currentProgramItemDelegate: CurrentProgramItemDelegate) : BaseRecyclerViewAdapter<CurrentProgramViewHolder, CurrentProgramVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentProgramViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_current_program, parent, false)
        return CurrentProgramViewHolder(view,currentProgramItemDelegate)
    }

}