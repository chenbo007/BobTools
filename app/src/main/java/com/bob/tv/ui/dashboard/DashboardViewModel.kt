package com.bob.tv.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun testLv() {

        viewModelScope.launch(Dispatchers.Main) {
            val num = async(Dispatchers.IO) {
                testNum()
            }

            val numx = num.await()
        }
//        retrofit<BaseResult<MutableList<Movie>>> {
//            api = Net.create(NetApi::class.java).getMovieList()
//            onFail { msg, errorCode ->
//
//            }
//            onComplete {
//
//            }
//            onSuccess {
//
//            }
//
//        }
    }

    fun testNum(): Int {
        return 5
    }
}