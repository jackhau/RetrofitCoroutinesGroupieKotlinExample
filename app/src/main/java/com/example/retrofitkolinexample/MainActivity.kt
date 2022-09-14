package com.example.retrofitkolinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitkolinexample.databinding.ActivityMainBinding
import com.example.retrofitkolinexample.item.UserItem
import com.example.retrofitkolinexample.retrofit.Status
import com.example.retrofitkolinexample.viewmodel.UserViewModel
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val groupAdapter = GroupieAdapter()
    private var mSection = Section()
    private var updatableItem = ArrayList<UserItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getUserRepo.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.data?.forEach {data ->
                        updatableItem.add(UserItem(data))
                    }
                    mSection.update(updatableItem)
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

        mBinding.recycleView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }
        groupAdapter.add(mSection)
    }
}