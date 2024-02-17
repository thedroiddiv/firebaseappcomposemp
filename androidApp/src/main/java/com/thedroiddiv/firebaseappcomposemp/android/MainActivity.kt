package com.thedroiddiv.firebaseappcomposemp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.thedroiddiv.firebaseappcomposemp.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Firebase.initialize(this)
        setContent {
            App(darkTheme = isSystemInDarkTheme(), dynamicColors = true)
        }
    }
}

