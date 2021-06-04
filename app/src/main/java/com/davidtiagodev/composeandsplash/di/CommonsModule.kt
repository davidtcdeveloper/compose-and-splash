package com.davidtiagodev.composeandsplash.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class DispatcherIo()

@Module
@InstallIn(SingletonComponent::class)
object CommonsModule {

    @Provides
    @DispatcherIo
    fun provideIoDispatcher():CoroutineDispatcher = Dispatchers.IO
}
