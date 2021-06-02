package com.davidtiagodev.composeandsplash.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class GenericHeaderDelegate(
    private val key: String,
    private val value: String
) {
    fun invoke(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val headerRequest: Request = originalRequest.newBuilder()
            .header(key, value)
            .method(originalRequest.method, originalRequest.body)
            .build()
        return chain.proceed(headerRequest)
    }
}
