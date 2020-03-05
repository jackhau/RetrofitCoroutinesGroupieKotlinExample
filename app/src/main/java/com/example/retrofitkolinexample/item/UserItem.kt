package com.example.retrofitkolinexample.item

import com.example.retrofitkolinexample.R
import com.example.retrofitkolinexample.databinding.ItemUserBinding
import com.example.retrofitkolinexample.model.User
import com.example.retrofitkolinexample.viewmodel.UserViewModel
import com.xwray.groupie.databinding.BindableItem


/**
 * Created by Jack Hau on 2020-03-05.
 */

class UserItem(user: User) : BindableItem<ItemUserBinding>() {

    private var userViewModel = UserViewModel()

    init {
        userViewModel.user = user
    }

    override fun getLayout() = R.layout.item_user

    override fun bind(viewBinding: ItemUserBinding, position: Int) {
        viewBinding.viewModel = userViewModel
    }

}