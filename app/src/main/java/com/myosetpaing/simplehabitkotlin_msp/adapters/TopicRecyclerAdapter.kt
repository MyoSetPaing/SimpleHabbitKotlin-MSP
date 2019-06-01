package com.myosetpaing.simplehabitkotlin_msp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO
import com.myosetpaing.simplehabitkotlin_msp.views.holders.TopicViewHolder

class TopicRecyclerAdapter() : BaseRecyclerViewAdapter<TopicViewHolder, TopicVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_topic, parent, false)
        return TopicViewHolder(view)
    }

}