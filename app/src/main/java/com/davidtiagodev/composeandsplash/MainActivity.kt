package com.davidtiagodev.composeandsplash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.davidtiagodev.composeandsplash.feed.FeedViewModel
import com.davidtiagodev.composeandsplash.feed.ui.FeedScreen
import com.davidtiagodev.composeandsplash.feed.ui.PhotosTabRow
import com.davidtiagodev.composeandsplash.ui.theme.ComposeAndSplashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotosApp()
        }
    }
}

@Composable
fun PhotosApp() {
    ComposeAndSplashTheme {
        val allScreens = PhotoScreen.values().toList()
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = PhotoScreen.fromRoute(
            backstackEntry.value?.destination?.route
        )
        Scaffold(
            topBar = {
                PhotosTabRow(
                    allScreens = allScreens,
                    onTabSelected = { screen ->
                        navController.navigate(screen.name)
                    },
                    currentScreen = currentScreen,
                )
            }
        ) { innerPadding ->
            PhotosNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun PhotosNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = PhotoScreen.Feed.name,
        modifier = modifier
    ) {
        composable(PhotoScreen.Feed.name) {
            val viewModel: FeedViewModel = hiltViewModel()
            FeedScreen(viewModel)
        }
        composable(PhotoScreen.Popular.name) {
            val viewModel: FeedViewModel = hiltViewModel()
            FeedScreen(viewModel)
        }
    }
}
