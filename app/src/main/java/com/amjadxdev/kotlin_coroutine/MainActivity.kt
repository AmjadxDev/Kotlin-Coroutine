package com.amjadxdev.kotlin_coroutine

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var counterText : TextView

        private val TAG = "KOTLINFUN"

    lateinit var mainViewModel : MainViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.counterText)
//        Log.d(TAG, "${Thread.currentThread().name}")

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        lifecycleScope.launch {
            delay(3000)
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            finish()
        }


    }

    fun updateCounter(view: View) {
        counterText.text = "${counterText.text.toString().toInt() +1 }"
    }

    fun doAction(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            executeTask()
        }
    }

    private suspend fun executeTask() {
        Log.d(TAG, "Before")
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG, "Inside")

        }

        Log.d(TAG, "after")

    }




}