package com.myosetpaing.simplehabitkotlin_msp.persistence.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO

@Dao
interface CurrentProgramDao {

    @Query("select * from CurrentProgram")
    fun getCurrentProgram(): LiveData<CurrentProgramVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentProgram(currentProgram: CurrentProgramVO)

    @Query("select count(*) from CurrentProgram")
    fun getCurrentProgramCount(): Int
}
