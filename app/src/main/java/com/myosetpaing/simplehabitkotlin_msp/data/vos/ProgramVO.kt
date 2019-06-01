package com.myosetpaing.simplehabitkotlin_msp.data.vos

import com.google.gson.annotations.SerializedName

data class ProgramVO(
    @SerializedName("program-id")
    var programId: String? = null,

    @SerializedName("title")
    var programTitle: String? = null,

    @SerializedName("image")
    var programImage: String? = null,

    @SerializedName("average-lengths")
    var averageLength: List<Int>,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("sessions")
    var session: List<SessionVO>? = null

)


