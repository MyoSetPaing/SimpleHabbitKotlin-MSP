package com.myosetpaing.simplehabitkotlin_msp.delegate

import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO

interface TopicDelegate{
    fun onSuccess(topicList: List<TopicVO>)
    fun onFail(message: String)
}