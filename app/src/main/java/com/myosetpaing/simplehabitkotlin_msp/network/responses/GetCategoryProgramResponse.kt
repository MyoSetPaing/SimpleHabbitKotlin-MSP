package com.myosetpaing.simplehabitkotlin_msp.network.responses

import com.google.gson.annotations.SerializedName
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO

class GetCategoryProgramResponse : BaseResponse() {

    @SerializedName("page")
    var page: String? = null
    @SerializedName("categoriesPrograms")
    val categoryProgram: List<CategoryProgramVO>? = null

}