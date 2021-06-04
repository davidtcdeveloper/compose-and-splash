package com.davidtiagodev.composeandsplash.feed.data.remote

import retrofit2.http.GET

interface GetPhotosService {
    @GET("/photos")
    suspend fun get(): List<Photo>
}
