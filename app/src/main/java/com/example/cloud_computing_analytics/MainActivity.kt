package com.example.cloud_computing_analytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cloud_computing_analytics.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.Param
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        analytics = Firebase.analytics
        binding.btnContentEvent.setOnClickListener {
            selectContentEvent("1", "Test1", "TestStr")
        }
        binding.btnTrackScreen.setOnClickListener {
            trackScreenEvent()
        }
    }
    fun selectContentEvent(id: String, name: String, contentType: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
            param(Param.ITEM_ID, id)
            param(Param.ITEM_NAME, name)
            param(Param.CONTENT_TYPE, contentType)
        }
    }
    fun trackScreenEvent() {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(Param.SCREEN_NAME, "main")
            param(Param.SCREEN_CLASS, "MainActivity")
        }
    }
}