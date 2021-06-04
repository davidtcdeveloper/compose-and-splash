package com.davidtiagodev.composeandsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.davidtiagodev.composeandsplash.feed.FeedViewModel
import com.davidtiagodev.composeandsplash.feed.ui.FeedScreen
import com.davidtiagodev.composeandsplash.ui.theme.ComposeAndSplashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndSplashTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FeedScreen(viewModel)
                }
            }
        }
    }
}
