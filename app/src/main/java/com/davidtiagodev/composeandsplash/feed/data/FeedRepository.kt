package com.davidtiagodev.composeandsplash.feed.data

import com.davidtiagodev.composeandsplash.di.DispatcherIo
import com.davidtiagodev.composeandsplash.feed.data.remote.GetLatestPhotosService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class FeedRepository @Inject constructor(
    private val getPhotosService: GetLatestPhotosService,
    @DispatcherIo private val dispatcher: CoroutineDispatcher,
) {
    suspend fun loadFeed(): List<Item> = withContext(dispatcher) {
        getPhotosService.get()
            .map { photo ->
                Item(
                    title = photo.description ?: "",
                    imageContentDescription = photo.description ?: "",
                    image = photo.urls.regular,
                )
            }
    }
}
