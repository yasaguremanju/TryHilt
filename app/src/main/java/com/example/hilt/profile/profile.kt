package com.example.hilt.profile

import javax.inject.Inject

// A resource
data class Profile(
    val name: String,
    val age: Int
)

// A simple interface which returns the resource.
// This will help us mock the data source when executing tests.
interface DataRepository {

    fun getProfile(): Profile
}

// Simple implementation of data source
class DataRepoImpl @Inject constructor(): DataRepository {

    override fun getProfile(): Profile =
        Profile(name = "Bruce Wayne", age = 42)
}