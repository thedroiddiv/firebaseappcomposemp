package com.thedroiddiv.firebaseappcomposemp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform