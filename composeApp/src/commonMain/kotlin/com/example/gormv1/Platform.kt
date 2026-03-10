package com.example.gormv1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform