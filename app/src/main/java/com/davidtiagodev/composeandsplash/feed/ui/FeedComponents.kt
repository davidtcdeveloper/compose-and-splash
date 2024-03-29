package com.davidtiagodev.composeandsplash.feed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidtiagodev.composeandsplash.R
import com.davidtiagodev.composeandsplash.feed.data.Item
import com.davidtiagodev.composeandsplash.ui.theme.ComposeAndSplashTheme
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun FeedList(feedItems: List<Item>) {
    LazyColumn {
        items(feedItems) { item ->
            FeedItem(item = item)
        }
    }
}

@Composable
fun FeedItem(
    item: Item,
) {
    Column {
        Image(
            painter = rememberCoilPainter(
                request = item.image,
                fadeIn = true,
                previewPlaceholder = R.drawable.ic_launcher_background,
            ),
            contentDescription = item.imageContentDescription,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = item.title,
            style = typography.h3,
        )
        Spacer(Modifier.width(16.dp))
    }
}

@Preview
@Composable
fun PreviewFeedList() {
    val items = listOf(
        Item(
            title = "Title 1",
            image = "https://picsum.photos/300/300",
            imageContentDescription = "Content description of the random image"
        ),
        Item(
            title = "Title 2",
            image = "https://picsum.photos/300/300",
            imageContentDescription = "Content description of the random image"
        ),
        Item(
            title = "Title 3",
            image = "https://picsum.photos/300/300",
            imageContentDescription = "Content description of the random image"
        ),
    )
    ComposeAndSplashTheme {
        FeedList(feedItems = items)
    }
}

@Preview
@Composable
fun PreviewFeedItem() {
    ComposeAndSplashTheme {
        FeedItem(
            Item(
                title = "This is a title",
                image = "https://picsum.photos/300/300",
                imageContentDescription = "Content description of the random image"
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
