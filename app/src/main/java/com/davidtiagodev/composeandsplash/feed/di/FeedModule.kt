package com.davidtiagodev.composeandsplash.feed.di

import com.davidtiagodev.composeandsplash.feed.data.remote.GetPhotoFeedService
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
    fun provideRandomPictureService(retrofitClientCreator: RetrofitClientCreator): GetPhotoFeedService =
        retrofitClientCreator.create().create(GetPhotoFeedService::class.java)
}
