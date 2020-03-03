package com.example.retrofitkolinexample.retrofit

import com.example.retrofitkolinexample.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Jack Hau on 2020-03-03.
 */

class ServiceGenerator {
    companion object {
        private val httpClient = OkHttpClient.Builder()

        fun createRetrofit(): TaskService {
            val client = httpClient.build()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TaskService::class.java)
        }
    }
}