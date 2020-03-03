package com.example.retrofitkolinexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitkolinexample.repository.UserRepo
import kotlinx.coroutines.Dispatchers

/**
 * Created by Jack Hau on 2020-03-03.
 */

class UserViewModel : ViewModel() {
    private val userRepo: UserRepo = UserRepo()

    val getUserRepo = liveData(Dispatchers.IO) {
        val getUser = userRepo.getUserListData()
        emit(getUser)
    }
}