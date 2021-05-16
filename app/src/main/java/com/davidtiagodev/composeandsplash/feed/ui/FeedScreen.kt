package com.davidtiagodev.composeandsplash.feed.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidtiagodev.composeandsplash.feed.FeedState
import com.davidtiagodev.composeandsplash.feed.FeedViewModel
import com.davidtiagodev.composeandsplash.ui.theme.ComposeAndSplashTheme

@Composable
fun FeedScreen(viewModel: FeedViewModel) {
    val state by viewModel.todoItems.observeAsState(FeedState.Loaded(emptyList()))

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
            Column(modifier = modifier.padding(8.dp)) {
                FeedList(state.items)
            }
        }
        FeedState.Loading -> LoadingFeed()
    }
}

@Preview
@Composable
fun PreviewFeedScreen() {
    val viewModel = FeedViewModel() // TODO Add items
    ComposeAndSplashTheme {
        FeedScreen(viewModel)
    }
}
