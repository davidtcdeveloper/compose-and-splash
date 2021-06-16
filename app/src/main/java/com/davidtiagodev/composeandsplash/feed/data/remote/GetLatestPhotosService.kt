package com.davidtiagodev.composeandsplash.feed.data.remote

import retrofit2.http.GET

interface GetLatestPhotosService {
    @GET("/photos")
    suspend fun get(): List<Photo>
}
