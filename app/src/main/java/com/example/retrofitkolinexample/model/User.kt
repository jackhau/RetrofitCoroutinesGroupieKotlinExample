package com.example.retrofitkolinexample.model


/**
 * Created by Jack Hau on 2020-03-03.
 */

data class User(
    val id: Int? = null,
    val name: String? = null,
    val color: String? = null
) {
    fun getUserMessage(): String {
        return "User name: $name UserId : $id"
    }
}