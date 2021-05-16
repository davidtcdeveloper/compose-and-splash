package com.davidtiagodev.composeandsplash.feed.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.davidtiagodev.composeandsplash.feed.data.Item
import com.davidtiagodev.composeandsplash.ui.theme.ComposeAndSplashTheme

@Composable
fun FeedList(feedItems: List<Item>) {
    LazyColumn {
        items(feedItems) { item ->
            FeedItem(item = item)
        }
    }
}


@Preview
@Composable
fun PreviewFeedList() {
    val items = listOf(
        Item("Title 1", "Description 1"),
        Item("Title 2", "Description 2"),
        Item("Title 3", "Description 3"),
    )
    ComposeAndSplashTheme {
        FeedList(feedItems = items)
    }
}

@Composable
fun FeedItem(
    item: Item,
) {
    Column {
        Text(
            text = item.title,
            style = typography.h3,
        )
        Text(
            text = item.description,
            style = typography.body1,
        )
    }
}

@Preview
@Composable
fun PreviewFeedItem() {
    ComposeAndSplashTheme {
        FeedItem(
            Item(
                title = "This is a title",
                description = "This is a description",
            )
        )
    }
}

@Composable
fun LoadingFeed() {
    Text(text = "Loading feed, please wait")
}

@Preview
@Composable
fun PreviewLoadingFeed() {
    LoadingFeed()
}
