package com.insoft.firstcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.insoft.firstcompose.models.QuotesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.BufferedReader

object DataManager {

    var quotes = emptyArray<QuotesModel>()
    val isloading = mutableStateOf(true)
    val error = mutableStateOf(false)
    suspend fun loadNotesFromJson(context: Context, fileName: String = "quotes.json"){
        delay(3000)
         try {
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(inputStream.reader())
            val jsonString = reader.readText()
             withContext(Dispatchers.IO) {
                 reader.close()
             }
            quotes =   Gson().fromJson(jsonString, Array<QuotesModel>::class.java)
            isloading.value = false
        } catch (e: Exception) {
            e.printStackTrace()
             error.value = true
        }
    }
}