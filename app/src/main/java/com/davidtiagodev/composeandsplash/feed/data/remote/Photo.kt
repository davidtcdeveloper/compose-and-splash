package com.davidtiagodev.composeandsplash.feed.data.remote

data class Photo(
    val description: String?,
    val urls: Urls
)

data class Urls(val regular: String)
