package com.amjadxdev.kotlin_coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val TAG = "KOTLINFUN"
    init {
        viewModelScope.launch {
            while (true) {
                Log.d(TAG, "viewmmodel scope start")
                delay(1000)
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"view MOdel destroy" )
    }
}