package com.thedroiddiv.firebaseappcomposemp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.thedroiddiv.firebaseappcomposemp.data.User
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    ) {
        var list by remember { mutableStateOf(listOf<User>()) }
        LaunchedEffect(Unit) {
            val firebaseFirestore = Firebase.firestore
            val userResponse = firebaseFirestore.collection("users").get()
            list = userResponse.documents.map { it.data() }
        }
        Surface(Modifier.fillMaxSize()) {
            LazyColumn(Modifier.fillMaxSize()) {
                items(list.size) { idx ->
                    val item = list[idx]
                    ListItem(
                        headlineContent = {
                            Text(text = item.name)
                        },
                        overlineContent = { Text(text = item.email) }
                    )
                }
            }
        }
    }
}