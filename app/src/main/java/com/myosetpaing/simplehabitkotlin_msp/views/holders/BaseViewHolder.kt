package com.myosetpaing.simplehabitkotlin_msp.views.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<W : Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected lateinit var mData: W

    abstract fun setData(data: W)
}