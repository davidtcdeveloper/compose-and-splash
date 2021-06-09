package com.davidtiagodev.composeandsplash.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtiagodev.composeandsplash.feed.data.FeedRepository
import com.davidtiagodev.composeandsplash.feed.data.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
) : ViewModel() {

    private val _feedFlow = MutableStateFlow<FeedState>(FeedState.Loading)
    val feedFlow: Flow<FeedState>
        get() = _feedFlow

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            _feedFlow.emit(FeedState.Loading)
            _feedFlow.emit(
                FeedState.Loaded(
                    items = feedRepository.loadFeed()
                )
            )
        }
    }
}

sealed class FeedState {
    object Loading : FeedState()
    data class Loaded(val items: List<Item>) : FeedState()
}
