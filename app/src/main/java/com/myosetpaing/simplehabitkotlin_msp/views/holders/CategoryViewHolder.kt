package com.myosetpaing.simplehabitkotlin_msp.views.holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.myosetpaing.simplehabitkotlin_msp.adapters.ProgramAdapter
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.ProgramVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramItemDelegate
import kotlinx.android.synthetic.main.view_item_category.view.*

class CategoryViewHolder(itemView: View, private val categoryProgramItemDelegate: CategoryProgramItemDelegate) : BaseViewHolder<CategoryProgramVO>(itemView) {

    private lateinit var mProgramAdapter: ProgramAdapter

    override fun setData(data: CategoryProgramVO) {

        mProgramAdapter = ProgramAdapter(categoryProgramItemDelegate, data.categoryId!!)

        itemView.tvItemCategory.text = data.title
        itemView.rvItemCategory.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        itemView.rvItemCategory.adapter = mProgramAdapter

        mProgramAdapter.setNewData(data.programs as MutableList<ProgramVO>)
    }


}