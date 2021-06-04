package com.davidtiagodev.composeandsplash.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtiagodev.composeandsplash.feed.data.FeedRepository
import com.davidtiagodev.composeandsplash.feed.data.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
) : ViewModel() {
    private var _feedState = MutableLiveData<FeedState>(FeedState.Loaded(emptyList()))
    val feedState: LiveData<FeedState> = _feedState

    init {
        refresh()
    }

    fun refresh() {
        _feedState.value = FeedState.Loading
        viewModelScope.launch {
            _feedState.postValue(
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
