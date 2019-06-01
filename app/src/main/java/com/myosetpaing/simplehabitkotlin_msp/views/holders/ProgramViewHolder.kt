package com.myosetpaing.simplehabitkotlin_msp.views.holders

import android.view.View
import com.myosetpaing.simplehabitkotlin_msp.data.vos.ProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramItemDelegate
import kotlinx.android.synthetic.main.view_item_program.view.*

class ProgramViewHolder(
    itemView: View,
    val categoryProgramItemDelegate: CategoryProgramItemDelegate,
    val itemId: String
) : BaseViewHolder<ProgramVO>(itemView) {


    override fun setData(data: ProgramVO) {

        itemView.tvProgramTitle.text = data.programTitle
        itemView.tvProgramDuration.text = data.averageLength[0].toString() + " mins"
        itemView.cvItemProgram.setOnClickListener {
            categoryProgramItemDelegate.onTapCategoryProgram(data, itemId, adapterPosition)
        }

    }

}