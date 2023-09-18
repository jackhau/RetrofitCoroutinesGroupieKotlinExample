package com.example.retrofitkolinexample.model

import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserTest {

    @MockK
    private lateinit var user: User

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        user = mockk()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testUserValue() {
        every { user.name } returns "hau"
        Assert.assertEquals("hau", user.name)
    }

    @Test
    fun testUserMessageWithMockk() {
        every { user.getUserMessage() } returns "User name: tan jack hau UserId : 223"
        Assert.assertEquals("User name: tan jack hau UserId : 223", user.getUserMessage())
    }

    @Test
    fun test() {
        val user = User(123, "jack hau")
        Assert.assertEquals("User name: jack hau UserId : 123", user.getUserMessage())
    }
}