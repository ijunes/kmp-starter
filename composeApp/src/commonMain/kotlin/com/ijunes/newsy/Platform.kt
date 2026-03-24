package com.ijunes.newsy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform