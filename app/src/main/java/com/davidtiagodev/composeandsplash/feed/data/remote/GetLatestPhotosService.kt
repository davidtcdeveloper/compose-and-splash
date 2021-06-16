package com.davidtiagodev.composeandsplash.feed.data.remote

import retrofit2.http.GET

interface GetLatestPhotosService {
    @GET("/photos?order_by=latest")
    suspend fun get(): List<Photo>
}
