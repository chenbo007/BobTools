package com.bob.tv.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bob.tools.net.retrofit
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    val test = MutableLiveData<String>()

    fun getData() {
        viewModelScope.launch {
            delay(3000)
            test.value = "xxx"
        }
    }
}