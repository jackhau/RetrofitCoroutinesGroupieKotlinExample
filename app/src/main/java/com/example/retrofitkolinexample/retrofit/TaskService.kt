package com.example.retrofitkolinexample.retrofit

import com.example.retrofitkolinexample.model.ResultResponse
import com.example.retrofitkolinexample.model.User
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Jack Hau on 2020-03-03.
 */

interface TaskService {
    @GET("api/unknown")
    suspend fun getUserList(): ResultResponse<User>
}