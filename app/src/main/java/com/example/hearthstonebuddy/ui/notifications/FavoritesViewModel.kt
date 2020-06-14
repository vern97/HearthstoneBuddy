package com.example.hearthstonebuddy.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Your favorite cards will be displayed here"
    }
    val text: LiveData<String> = _text
}