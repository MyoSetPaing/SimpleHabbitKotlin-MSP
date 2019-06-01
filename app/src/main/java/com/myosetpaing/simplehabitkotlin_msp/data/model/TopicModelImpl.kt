package com.myosetpaing.simplehabitkotlin_msp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO
import com.myosetpaing.simplehabitkotlin_msp.delegate.TopicDelegate
import com.myosetpaing.simplehabitkotlin_msp.network.SimpleHabitDA

object TopicModelImpl: BaseModel(),TopicModel{

    override fun getTopic(isForce: Boolean, networkFailure: (String) -> Unit): LiveData<List<TopicVO>> {

        if (mDataBase.isTopicEmpty || isForce){
            mDataAgent.getTopics(SimpleHabitDA.ACCESS_TOKEN,1,object : TopicDelegate{
                override fun onSuccess(topicList: List<TopicVO>) {

                    mDataBase.getTopicDao.insertTopics(topicList)
                }

                override fun onFail(message: String) {
                    networkFailure(message)
                }

            })
        }
        return  mDataBase.getTopicDao.getTopics()
    }

}