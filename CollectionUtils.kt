package com.example.library

inline fun <reified T> List<*>.filterByType(): List<T> {
    return filterIsInstance<T>()
}
