package com.myosetpaing.simplehabitkotlin_msp.data.vos

import com.google.gson.annotations.SerializedName

class SessionVO{

    @SerializedName("session-id")
    var sessionId: String? = null

    @SerializedName("title")
    var sessionTitle: String? = null

    @SerializedName("length-in-seconds")
    var lengthInSeconds: Int = 0

    @SerializedName("file-path")
    var filePath: String? = null
}