package com.myosetpaing.simplehabitkotlin_msp.views.holders

import android.view.View
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO
import kotlinx.android.synthetic.main.view_item_topic.view.*

class TopicViewHolder(itemView: View) : BaseViewHolder<TopicVO>(itemView) {

    override fun setData(data: TopicVO) {
        itemView.tvTopicTitle.text = data.topicName
        itemView.tvTopicDescription.text = data.topicDesc
    }

}