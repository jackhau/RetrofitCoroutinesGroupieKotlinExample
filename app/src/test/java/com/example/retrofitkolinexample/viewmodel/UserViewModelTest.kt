package com.example.retrofitkolinexample.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.retrofitkolinexample.getOrAwaitValue
import com.example.retrofitkolinexample.repository.UserRepo
import com.example.retrofitkolinexample.retrofit.Status
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UserViewModelTest {
    private lateinit var userViewModel: UserViewModel
    @MockK
    private lateinit var userRepo: UserRepo
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        userViewModel = UserViewModel()
        userRepo = mockk(relaxed = true)
        Dispatchers.setMain(Dispatchers.Unconfined)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetUserRepoWithSUCCESSStatus() {
        runTest {
            coEvery { userRepo.getUserName() } returns "Tan "
            val result = userViewModel.getUserRepoWithLoading.getOrAwaitValue()
            Assert.assertEquals(Status.SUCCESS, result.status)
        }
    }

    @Test
    fun testGetUserName() {
        runTest {
            coEvery { userRepo.getUserName() } returns "Tan "
            val result = userViewModel.getUserName.getOrAwaitValue()
            Assert.assertEquals("Jack Hau", result)
        }
    }

    @Test
    fun testGetUserRepo() {
        runTest {
            val result = userViewModel.getUserRepo.getOrAwaitValue()
            Assert.assertEquals(Status.LOADING, result.status)
        }
    }
}