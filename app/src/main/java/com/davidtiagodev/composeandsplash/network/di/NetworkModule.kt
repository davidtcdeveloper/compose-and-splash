package com.davidtiagodev.composeandsplash.network.di

import com.davidtiagodev.composeandsplash.BuildConfig
import com.davidtiagodev.composeandsplash.network.AcceptVersionInterceptor
import com.davidtiagodev.composeandsplash.network.PublicAuthorizationInterceptor
import com.davidtiagodev.composeandsplash.network.RetrofitClientCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        @Provides
        @Singleton
        @Named("apiPublicKey")
        fun provideApiPublicKey(): String = BuildConfig.API_ACCESS_KEY

        @Provides
        @Singleton
        @Named("baseUrl")
        fun provideBseUrl(): String = "https://api.unsplash.com/"

        @Provides
        @Singleton
        fun provideRetrofitCreator(
            @Named("baseUrl") baseUrl: String,
            acceptVersionInterceptor: AcceptVersionInterceptor,
            publicAuthorizationInterceptor: PublicAuthorizationInterceptor
        ) =
            RetrofitClientCreator(
                baseUrl,
                setOf(acceptVersionInterceptor, publicAuthorizationInterceptor)
            )
    }
}
