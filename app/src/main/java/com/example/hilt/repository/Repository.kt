package com.example.hilt.repository

interface Repository<T> {
   suspend fun fetch():T
   suspend fun get():T
   fun getRepository():Repository<T>

}