package com.davidtiagodev.composeandsplash.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtiagodev.composeandsplash.feed.data.Item
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private var _todoItems = MutableLiveData<FeedState>(FeedState.Loaded(emptyList()))
    val todoItems: LiveData<FeedState> = _todoItems

    init {
        refresh()
    }

    fun refresh() {
        _todoItems.value = FeedState.Loading
        viewModelScope.launch {
            delay(1000)
            _todoItems.value = FeedState.Loaded(
                items = listOf(
                    Item(title = "Title 1", description = "Description 1"),
                    Item(title = "Title 2", description = "Description 2"),
                    Item(title = "Title 3", description = "Description 3"),
                    Item(title = "Title 4", description = "Description 4"),
                )
            )
        }
    }
}

sealed class FeedState {
    object Loading : FeedState()
    data class Loaded(val items: List<Item>) : FeedState()
}
