package com.myosetpaing.simplehabitkotlin_msp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.data.vos.ProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramItemDelegate
import com.myosetpaing.simplehabitkotlin_msp.views.holders.ProgramViewHolder

class ProgramAdapter(private val categoryProgramItemDelegate: CategoryProgramItemDelegate, val itemId: String) :
    BaseRecyclerViewAdapter<ProgramViewHolder, ProgramVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_item_program, parent, false)
        return ProgramViewHolder(itemView, categoryProgramItemDelegate, itemId)

    }

}