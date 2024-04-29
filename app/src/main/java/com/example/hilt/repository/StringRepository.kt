package com.example.hilt.repository

import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject
import kotlin.IllegalArgumentException
import kotlin.random.Random

class StringRepository @Inject constructor() : Repository<String> {

    @Throws
    override suspend fun fetch(): String {
        Timber.d("[fetch]  start")
        delay(1000)
        Timber.d("[fetch]  end")
        if (Random.nextBoolean()) {
            throw IllegalArgumentException()
        }
        return "AAA"
    }

    @Throws
    override suspend fun get(): String {
        Timber.d("[get] start")
        delay(5000)
        Timber.d("[get] end")
        if (Random.nextBoolean()) {
            throw IllegalArgumentException()
        }
        return "BBB"
    }

    override fun getRepository(): Repository<String> {
        return StringRepository()
    }


}