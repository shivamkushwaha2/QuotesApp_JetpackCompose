package com.insoft.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.insoft.firstcompose.DataManager.loadNotesFromJson
import com.insoft.firstcompose.app.MyApp
import com.insoft.firstcompose.models.QuotesModel
import com.insoft.firstcompose.screens.QuoteDetailItem
import com.insoft.firstcompose.screens.QuoteListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            loadNotesFromJson(applicationContext)
        }
        setContent {
           MyApp()
        }
    }
}

//@Composable
//fun AppNavigation(modifier: Modifier = Modifier) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "ShowQuoteList") {
//        composable("ShowQuoteList") {
//            ShowQuoteList(modifier, navController)
//        }
//        composable("QuoteDetailItem/{text}/{author}") { it: NavBackStackEntry ->
//            val text = it.arguments?.getString("text")
//            val author = it.arguments?.getString("author")
//            QuoteDetailItem(text, author)
//        }
//    }
//}

