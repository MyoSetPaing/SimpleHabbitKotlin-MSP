package com.myosetpaing.simplehabitkotlin_msp.persistence.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO

@Dao
interface CategoryProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryPrograms(programList: List<CategoryProgramVO>)

    @Query("select * from category_program")
    fun getCategoryProgram(): LiveData<List<CategoryProgramVO>>

    @Query("select count(*) from category_program")
    fun getCategoryProgramCount(): Int

    @Query("select * from category_program where category_id=:categoryId")
    fun getCategoryProgramById(categoryId: String): LiveData<CategoryProgramVO>
}
