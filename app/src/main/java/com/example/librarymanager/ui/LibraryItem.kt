package com.example.library

abstract class LibraryItem(
    val id: Int,
    var available: Boolean,
    open val name: String
) {
    open fun getShortInfo(): String {
        return "$name доступна: ${if (available) "Да" else "Нет"}"
    }

    abstract fun getDetailedInfo(): String
}