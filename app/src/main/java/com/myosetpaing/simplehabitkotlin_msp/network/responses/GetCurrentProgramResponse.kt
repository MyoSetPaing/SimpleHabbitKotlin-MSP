package com.myosetpaing.simplehabitkotlin_msp.network.responses

import com.google.gson.annotations.SerializedName
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO

class GetCurrentProgramResponse : BaseResponse() {

    @SerializedName("page")
    var page: String? = null
    @SerializedName("currentProgram")
    var currentProgram: CurrentProgramVO? = null
}