package com.insoft.firstcompose.app

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.insoft.firstcompose.Routes
import com.insoft.firstcompose.screens.LoginScreen
import com.insoft.firstcompose.screens.QuoteDetailItem
import com.insoft.firstcompose.screens.ShowQuoteList
import com.insoft.firstcompose.screens.SignUpScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {

        NavHost(
            navController = navController,
            startDestination = Routes.login
        ) {
            composable(Routes.login) {
                LoginScreen(navController)
            }
            composable(Routes.signup) { SignUpScreen(navController) }

            composable("ShowQuoteList") {
                ShowQuoteList(Modifier, navController)
            }
            composable("QuoteDetailItem/{text}/{author}") { it: NavBackStackEntry ->
                val text = it.arguments?.getString("text")
                val author = it.arguments?.getString("author")
                QuoteDetailItem(text, author)
            }
        }

    }
}
