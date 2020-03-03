package com.example.retrofitkolinexample.model


/**
 * Created by Jack Hau on 2020-03-03.
 */

data class ResultResponse<T>(
    val page: Int? = null,
    val total: Int? = null,
    val data: ArrayList<T>
)