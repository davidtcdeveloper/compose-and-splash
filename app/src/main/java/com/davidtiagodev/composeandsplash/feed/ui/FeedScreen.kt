package com.davidtiagodev.composeandsplash.feed.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.davidtiagodev.composeandsplash.feed.FeedState
import com.davidtiagodev.composeandsplash.feed.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val flow = viewModel.feedFlow
    val locationFlowLifecycleAware = remember(flow, lifecycleOwner) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }

    val state by locationFlowLifecycleAware.collectAsState(FeedState.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Feed")
                },
                actions = {
                    IconButton(onClick = { viewModel.refresh() }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            modifier = Modifier.padding(innerPadding),
            state = state,
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier, state: FeedState) {
    when (state) {
        is FeedState.Loaded -> {
            Column(modifier = modifier) {
                FeedList(state.items)
            }
        }
        FeedState.Loading -> LoadingFeed()
    }
}
