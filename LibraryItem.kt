package com.example.library

abstract class LibraryItem(
    val id: Int,
    var available: Boolean,
    val name: String
) {
    fun getShortInfo(): String {
        return "$name доступна: ${if (available) "Да" else "Нет"}"
    }

    abstract fun getDetailedInfo(): String
}