package com.myosetpaing.simplehabitkotlin_msp.network.responses

import com.google.gson.annotations.SerializedName
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO

class GetTopicResponse : BaseResponse() {

    @SerializedName("page")
    var page: String? = null
    @SerializedName("topics")
    var topics: List<TopicVO>? = null

}