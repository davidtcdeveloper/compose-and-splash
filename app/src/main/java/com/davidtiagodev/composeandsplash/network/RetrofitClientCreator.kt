package com.davidtiagodev.composeandsplash.network

import com.davidtiagodev.composeandsplash.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitClientCreator(
    private val baseUrl: String,
    private val unorderedInterceptors: Set<Interceptor>
) {
    fun create(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(buildOkHttp())
        .build()

    private fun buildOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptors()
            .build()

    private fun OkHttpClient.Builder.addInterceptors(): OkHttpClient.Builder {
        unorderedInterceptors.forEach { addInterceptor(it) }
        addLogInterceptor()
        return this
    }

    private fun OkHttpClient.Builder.addLogInterceptor() {
        if (BuildConfig.DEBUG) {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
        }
    }
}
