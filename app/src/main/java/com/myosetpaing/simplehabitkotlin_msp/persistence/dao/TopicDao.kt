package com.myosetpaing.simplehabitkotlin_msp.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO

@Dao
interface TopicDao {

    @Query("select * from topic")
    fun getTopics(): LiveData<List<TopicVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopics(topicList: List<TopicVO>)

    @Query("select count(*) from topic")
    fun getTopicsCount(): Int
}