package com.example.gormv1.utils

fun validateLogin(email: String, password: String) : Boolean {

    val users = mapOf(
        "leo@leo.com" to "1234"
    )
    return users.contains(email) && users[email] == password
}