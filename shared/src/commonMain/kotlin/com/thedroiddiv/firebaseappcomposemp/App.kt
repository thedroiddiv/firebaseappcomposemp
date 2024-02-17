package com.thedroiddiv.firebaseappcomposemp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    ) {
        Surface(Modifier.fillMaxSize()) {
            val platform = remember {
                getPlatform()
            }
            Text(text = platform.name)
        }

    }

}