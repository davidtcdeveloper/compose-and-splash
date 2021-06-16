package com.davidtiagodev.composeandsplash.feed.di

import com.davidtiagodev.composeandsplash.feed.data.remote.GetLatestPhotosService
import com.davidtiagodev.composeandsplash.network.RetrofitClientCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object FeedModule {

    @Provides
    @ViewModelScoped
    fun providePhotoFeedService(retrofitClientCreator: RetrofitClientCreator): GetLatestPhotosService =
        retrofitClientCreator.create().create(GetLatestPhotosService::class.java)
}
