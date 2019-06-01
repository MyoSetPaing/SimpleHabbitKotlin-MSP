package com.myosetpaing.simplehabitkotlin_msp.persistence


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO
import com.myosetpaing.simplehabitkotlin_msp.persistence.dao.CategoryProgramDao
import com.myosetpaing.simplehabitkotlin_msp.persistence.dao.CurrentProgramDao
import com.myosetpaing.simplehabitkotlin_msp.persistence.dao.TopicDao
import com.myosetpaing.simplehabitkotlin_msp.persistence.typeconverters.IntegerListConverter
import com.myosetpaing.simplehabitkotlin_msp.persistence.typeconverters.ProgramListConverter
import com.myosetpaing.simplehabitkotlin_msp.persistence.typeconverters.SessionListConverter

@Database(
    entities = [CurrentProgramVO::class, TopicVO::class, CategoryProgramVO::class], version = 1, exportSchema = false
)
@TypeConverters(SessionListConverter::class, IntegerListConverter::class, ProgramListConverter::class)
abstract class SimpleHabitDB : RoomDatabase() {

    abstract val getCategoryProgramDao: CategoryProgramDao
    abstract val getCurrentProgramDao: CurrentProgramDao
    abstract val getTopicDao: TopicDao

    companion object {
        private lateinit var INSTANCE: SimpleHabitDB
        private val DB_NAME = "simple_habit.DB"
        fun getDatabase(context: Context): SimpleHabitDB {
            INSTANCE = Room.databaseBuilder(context, SimpleHabitDB::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            return INSTANCE
        }

    }
    val isCurrentProgramEmpty: Boolean
        get() {
            val count = getCurrentProgramDao.getCurrentProgramCount()
            return count < 1
        }

    val isTopicEmpty: Boolean
        get() {
            val topicList = getTopicDao.getTopicsCount()
            return topicList < 1
        }

    val isCategoryProgramsEmpty: Boolean
        get() {
            val list = getCategoryProgramDao.getCategoryProgramCount()
            return list < 1
        }

}