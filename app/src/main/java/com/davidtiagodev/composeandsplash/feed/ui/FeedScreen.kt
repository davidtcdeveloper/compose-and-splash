package com.davidtiagodev.composeandsplash.feed.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.davidtiagodev.composeandsplash.feed.FeedState
import com.davidtiagodev.composeandsplash.feed.FeedViewModel

@Composable
fun FeedScreen() {
    val viewModel: FeedViewModel = viewModel()

    val lifecycleOwner = LocalLifecycleOwner.current
    val flow = viewModel.feedFlow
    val locationFlowLifecycleAware = remember(flow, lifecycleOwner) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }

    val state by locationFlowLifecycleAware.collectAsState(FeedState.Loading)

    FeedContent(
        state = state,
    )
}

@Composable
fun FeedContent(state: FeedState) {
    when (state) {
        is FeedState.Loaded -> {
            Column {
                FeedList(state.items)
            }
        }
        FeedState.Loading -> LoadingFeed()
    }
}
