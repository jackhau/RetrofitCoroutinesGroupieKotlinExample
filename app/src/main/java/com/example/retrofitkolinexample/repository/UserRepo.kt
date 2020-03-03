package com.example.retrofitkolinexample.repository

import com.example.retrofitkolinexample.model.ResultResponse
import com.example.retrofitkolinexample.model.User
import com.example.retrofitkolinexample.retrofit.Resource
import com.example.retrofitkolinexample.retrofit.ResponseHandler
import com.example.retrofitkolinexample.retrofit.ServiceGenerator


/**
 * Created by Jack Hau on 2020-03-03.
 */

class UserRepo {
    private val client = ServiceGenerator.createRetrofit()
    private val responseHandler = ResponseHandler()

    suspend fun getUserListData(): Resource<ResultResponse<User>> {
        return try {
            val response = client.getUserList()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}