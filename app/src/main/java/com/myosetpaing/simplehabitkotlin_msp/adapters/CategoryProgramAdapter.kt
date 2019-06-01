package com.myosetpaing.simplehabitkotlin_msp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramItemDelegate
import com.myosetpaing.simplehabitkotlin_msp.views.holders.CategoryViewHolder

class CategoryProgramAdapter(private val categoryProgramItemDelegate: CategoryProgramItemDelegate):BaseRecyclerViewAdapter<CategoryViewHolder,CategoryProgramVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_item_category, parent, false)
        return CategoryViewHolder(itemView, categoryProgramItemDelegate)
    }

}