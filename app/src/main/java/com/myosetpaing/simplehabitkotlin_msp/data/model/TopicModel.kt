package com.myosetpaing.simplehabitkotlin_msp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO


interface TopicModel {
    fun getTopic(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<TopicVO>>
}