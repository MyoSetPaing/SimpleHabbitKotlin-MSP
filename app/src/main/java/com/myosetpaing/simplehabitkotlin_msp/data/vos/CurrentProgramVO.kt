package com.myosetpaing.simplehabitkotlin_msp.data.vos


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CurrentProgram", indices = [Index(value = ["program_id"], unique = true)])
data class CurrentProgramVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "current_program_id")
    var currentProgramId: Int = 0,

    @ColumnInfo(name = "program_id")
    @SerializedName("program-id")
    var programId: String? = null,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var currentProgramTitle: String? = null,

    @ColumnInfo(name = "current_period")
    @SerializedName("current-period")
    var currentPeriod: String? = null,

    @ColumnInfo(name = "background")
    @SerializedName("background")
    var background: String? = null,

    @ColumnInfo(name = "tiaverage_lengthstle")
    @SerializedName("average-lengths")
    var averageLength: List<Int>? = null,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String? = null,

    @ColumnInfo(name = "sessions")
    @SerializedName("sessions")
    var session: List<SessionVO>? = null
)