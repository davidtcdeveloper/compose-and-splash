package com.davidtiagodev.composeandsplash

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class PhotoScreen(
    val icon: ImageVector,
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Feed(
        icon = Icons.Filled.PhotoLibrary,
        body = { com.davidtiagodev.composeandsplash.feed.ui.FeedScreen() }
    ),
    Popular(
        icon = Icons.Filled.People,
        body = { com.davidtiagodev.composeandsplash.feed.ui.FeedScreen() }
    );

    @Composable
    fun Content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: String?): PhotoScreen =
            when (route?.substringBefore("/")) {
                Feed.name -> Feed
                Popular.name -> Popular
                null -> Feed
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}
