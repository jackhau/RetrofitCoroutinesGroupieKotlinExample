package com.example.retrofitkolinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitkolinexample.databinding.ActivityMainBinding
import com.example.retrofitkolinexample.retrofit.Status
import com.example.retrofitkolinexample.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getUserRepo.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    mBinding.wording.text = "finish..."
                }
                Status.ERROR -> {
                    mBinding.wording.text = "error..."
                }
                Status.LOADING -> {
                    mBinding.wording.text = "loading..."
                }
            }
        })
    }
}