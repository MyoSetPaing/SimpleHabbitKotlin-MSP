package com.myosetpaing.simplehabitkotlin_msp.network

import com.google.gson.Gson
import com.myosetpaing.simplehabitkotlin_msp.delegate.CategoryProgramDelegate
import com.myosetpaing.simplehabitkotlin_msp.delegate.CurrentProgramDelegate
import com.myosetpaing.simplehabitkotlin_msp.delegate.TopicDelegate
import com.myosetpaing.simplehabitkotlin_msp.network.responses.GetCategoryProgramResponse
import com.myosetpaing.simplehabitkotlin_msp.network.responses.GetCurrentProgramResponse
import com.myosetpaing.simplehabitkotlin_msp.network.responses.GetTopicResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDA : SimpleHabitDA {

    val mSimpleHabitAPI: SimpleHabitAPI

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
        mSimpleHabitAPI = retrofit.create(SimpleHabitAPI::class.java)
    }

    override fun getCurrentProgram(token: String, page: Int, delegate: CurrentProgramDelegate) {

        mSimpleHabitAPI.loadCurrentProgram(token, page).enqueue(object : Callback<GetCurrentProgramResponse> {
            override fun onFailure(call: Call<GetCurrentProgramResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetCurrentProgramResponse>,
                response: Response<GetCurrentProgramResponse>
            ) {
                val currentProgramResponse = response.body()
                if (currentProgramResponse != null) {
                    if (currentProgramResponse.isResponseSuccess) {
                        val currentProgram = currentProgramResponse.currentProgram!!
                        delegate.onSuccess(currentProgram)
                    } else {
                        delegate.onFail(currentProgramResponse.message)
                    }

                } else {
                    delegate.onFail("Response is null")
                }
            }

        })

    }

    override fun getTopics(token: String, page: Int, delegate: TopicDelegate) {
        mSimpleHabitAPI.loadTopics(token, page).enqueue(object : Callback<GetTopicResponse> {
            override fun onFailure(call: Call<GetTopicResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetTopicResponse>, response: Response<GetTopicResponse>) {
                val topicResponse = response.body()
                if(topicResponse != null){
                    if(topicResponse.isResponseSuccess){
                        val topicList = topicResponse.topics
                        delegate.onSuccess(topicList!!)
                    }else{
                        delegate.onFail(topicResponse.message!!)
                    }
                }else{
                    delegate.onFail("Response is null")
                }
            }

        })

    }

    override fun getCategoriesPrograms(token: String, page: Int, delegate: CategoryProgramDelegate) {

        mSimpleHabitAPI.loadCategoryPrograms(token, page).enqueue(object : Callback<GetCategoryProgramResponse> {
            override fun onFailure(call: Call<GetCategoryProgramResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetCategoryProgramResponse>,
                response: Response<GetCategoryProgramResponse>
            ) {
                val categoryProgramResponse = response.body()
                if (categoryProgramResponse != null) {
                    if (categoryProgramResponse.isResponseSuccess) {
                        val categoryProgramList = categoryProgramResponse.categoryProgram
                        delegate.onSuccess(categoryProgramList!!)
                    } else {
                        delegate.onFail(categoryProgramResponse.message!!)
                    }
                } else {
                    delegate.onFail("Response is null")
                }

            }

        })
    }

}
