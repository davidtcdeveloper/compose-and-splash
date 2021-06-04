package com.davidtiagodev.composeandsplash.feed.di

import com.davidtiagodev.composeandsplash.feed.data.remote.GetPhotosService
import com.davidtiagodev.composeandsplash.network.RetrofitClientCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object FeedModule {

    @Provides
    @ActivityRetainedScoped
    fun provideRandomPictureService(retrofitClientCreator: RetrofitClientCreator): GetPhotosService =
        retrofitClientCreator.create().create(GetPhotosService::class.java)
}
