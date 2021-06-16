package com.davidtiagodev.composeandsplash.feed.data

import com.davidtiagodev.composeandsplash.di.DispatcherIo
import com.davidtiagodev.composeandsplash.feed.data.remote.GetLatestPhotosService
import com.davidtiagodev.composeandsplash.feed.data.remote.Photo
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class LatestRepository @Inject constructor(
    private val latestPhotosService: GetLatestPhotosService,
    @DispatcherIo private val dispatcher: CoroutineDispatcher,
) {
    suspend fun loadLatest(): List<Item> = withContext(dispatcher) {
        return@withContext latestPhotosService.get().mapToPhoto()
    }
}

private fun List<Photo>.mapToPhoto() = this.map { photo ->
    Item(
        title = photo.description ?: "",
        imageContentDescription = photo.description ?: "",
        image = photo.urls.regular,
    )
}
