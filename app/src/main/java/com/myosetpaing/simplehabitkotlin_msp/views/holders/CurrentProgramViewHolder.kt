package com.myosetpaing.simplehabitkotlin_msp.views.holders

import android.annotation.SuppressLint
import android.view.View
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramItemDelegate
import kotlinx.android.synthetic.main.view_item_current_program.view.*
class CurrentProgramViewHolder(itemView: View,val currentProgramItemDelegate: CurrentProgramItemDelegate): BaseViewHolder<CurrentProgramVO>(itemView){


    @SuppressLint("SetTextI18n")
    override fun setData(data: CurrentProgramVO) {
        mData = data
        itemView.tvCurrentProgramDuration.text = data.averageLength!![adapterPosition].toString() + "mins"
        itemView.tvCurrentProgramTitle.text =data.currentProgramTitle
        itemView.btnCurrentProgramPlay.text= data.currentPeriod

        itemView.rlItemCurrentProgram.setOnClickListener {
            currentProgramItemDelegate.onTapCurrentProgram(data)
        }
    }


}