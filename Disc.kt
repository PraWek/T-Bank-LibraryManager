package com.example.library

class Disc(
    id: Int,
    available: Boolean,
    name: String,
    val type: String
) : LibraryItem(id, available, name), Borrowable {
    override fun getDetailedInfo(): String {
        return "$type $name доступен: ${if (available) "Да" else "Нет"}"
    }

    override fun borrow() {
        if (available) {
            available = false
            println("Диск $name взяли домой")
        } else {
            println("Нельзя взять домой")
        }
    }

    override fun returnItem() {
        if (!available) {
            available = true
            println("Диск $name возвращён")
        } else {
            println("Этот диск уже доступен")
        }
    }
}