package com.example.learningquotes.dataConvertion

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.learningquotes.model.QuotesClass
import com.example.learningquotes.switchingClass.Pages
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<QuotesClass>()
    var currentPages = mutableStateOf(Pages.LISTING)
    var currentQuotes: QuotesClass? = null
    var isDataLoaded = mutableStateOf(false)

    // Load quotes from JSON file :->
    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<QuotesClass>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quotes: QuotesClass?) {
        if (currentPages.value == Pages.LISTING){
            currentQuotes = quotes
            currentPages.value = Pages.DETAIL
        }else {
            currentPages.value = Pages.LISTING
        }
    }
}