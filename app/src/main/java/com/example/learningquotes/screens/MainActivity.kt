package com.example.learningquotes.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.learningquotes.dataConvertion.DataManager
import com.example.learningquotes.switchingClass.Pages
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Calling Data Manager Asset File :->
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value){
        when(DataManager.currentPages.value){
            Pages.LISTING -> {
                QuoteListScreen(list = DataManager.data) {
                    DataManager.switchPages(it)
                }
            }
            Pages.DETAIL -> {
                DataManager.currentQuotes?.let { QuoteDetails(quotes = it) } // wrap with let.
            }
        }
    }else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineLarge
                )
        }
    }
}