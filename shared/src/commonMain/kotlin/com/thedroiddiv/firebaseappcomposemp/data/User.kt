package com.thedroiddiv.firebaseappcomposemp.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String
)