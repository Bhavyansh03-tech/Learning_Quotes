package com.example.learningquotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.learningquotes.adapter.QuoteListItem
import com.example.learningquotes.model.QuotesClass

// Main Screen :->
@Composable
fun QuoteListScreen(list: Array<QuotesClass>, onClick: (quotes: QuotesClass) -> Unit) {
    Column {
        Text(
            text ="Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineLarge
            )

        // Initializing Recyclerview :->
        QuoteRecyclerview(list = list, onClick)
    }
}

// Recyclerview :->
@Composable
fun QuoteRecyclerview(list: Array<QuotesClass>, onClick: (quotes: QuotesClass) -> Unit) {

    LazyColumn(content = {
        items(list) {
            QuoteListItem(quotes = it, onClick)
        }
    })
}