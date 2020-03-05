package com.example.retrofitkolinexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitkolinexample.model.User
import com.example.retrofitkolinexample.repository.UserRepo
import com.example.retrofitkolinexample.retrofit.Resource
import kotlinx.coroutines.Dispatchers

/**
 * Created by Jack Hau on 2020-03-03.
 */

class UserViewModel : ViewModel() {
    private val userRepo: UserRepo = UserRepo()
    var user = User()

    val getUserRepo = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(userRepo.getUserListData())
    }
}