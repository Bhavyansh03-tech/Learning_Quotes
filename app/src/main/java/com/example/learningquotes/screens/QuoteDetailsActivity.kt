package com.example.learningquotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.learningquotes.dataConvertion.DataManager
import com.example.learningquotes.model.QuotesClass

// After Item Clicked from list :->
@Composable
fun QuoteDetails(quotes: QuotesClass) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xffe9ecef),
                        Color.Gray
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp, 24.dp),
            colors = CardColors(containerColor = Color(0xff8392ab), disabledContainerColor = Color(0xff8392ab), contentColor = Color.White, disabledContentColor = Color.Black)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(70.dp)
                        .rotate(180f)
                )
                Text(
                    text = quotes.quote,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .height(1.dp)
                        .fillMaxWidth(.5f)
                )
                Text(
                    text = quotes.author,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
            }
        }
    }

}