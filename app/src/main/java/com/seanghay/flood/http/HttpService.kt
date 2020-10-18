package com.seanghay.flood.http

import retrofit2.http.GET

interface HttpService {

    @GET("posts")
    suspend fun posts(): List<Post>

    @GET("users")
    suspend fun users(): List<User>
}