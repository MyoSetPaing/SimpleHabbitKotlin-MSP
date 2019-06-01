package com.myosetpaing.simplehabitkotlin_msp.network

import com.myosetpaing.simplehabitkotlin_msp.network.responses.GetCategoryProgramResponse
import com.myosetpaing.simplehabitkotlin_msp.network.responses.GetCurrentProgramResponse
import com.myosetpaing.simplehabitkotlin_msp.network.responses.GetTopicResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SimpleHabitAPI{

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    fun loadCurrentProgram(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCurrentProgramResponse>

    @FormUrlEncoded
    @POST("getTopics.php")
    fun loadTopics(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetTopicResponse>

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    fun loadCategoryPrograms(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCategoryProgramResponse>

}