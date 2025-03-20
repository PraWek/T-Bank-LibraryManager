package com.example.library

class Book(
    id: Int,
    available: Boolean,
    name: String,
    val pageCount: Int,
    val author: String
) : LibraryItem(id, available, name), Borrowable, Readable {
    override fun getDetailedInfo(): String {
        return "книга: $name ($pageCount стр.) автора: $author с id: $id доступна: ${if (available) "Да" else "Нет"}"
    }

    override fun borrow() {
        if (available) {
            available = false
            println("Книгу $name взяли домой")
        } else {
            println("Нельзя взять домой")
        }
    }

    override fun readInLibrary() {
        if (available) {
            available = false
            println("Книгу $name взяли в читальный зал")
        } else {
            println("Нельзя взять в читальный зал")
        }
    }

    override fun returnItem() {
        if (!available) {
            available = true
            println("Книга $name возвращена")
        } else {
            println("Эта книга уже доступна")
        }
    }
}