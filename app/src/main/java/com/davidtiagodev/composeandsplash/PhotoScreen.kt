package com.davidtiagodev.composeandsplash

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

enum class PhotoScreen(
    val icon: ImageVector,
) {
    Feed(
        icon = Icons.Filled.PhotoLibrary,
    ),
    Popular(
        icon = Icons.Filled.People,
    );

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
