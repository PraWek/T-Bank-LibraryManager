package com.example.library

class Newspaper(
    id: Int,
    available: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, available, name), Borrowable, Readable {
    override fun getDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name с id: $id доступен: ${if (available) "Да" else "Нет"}"
    }

    override fun borrow() {
        println("Нельзя взять домой")
    }

    override fun readInLibrary() {
        if (available) {
            available = false
            println("Газету $name взяли в читальный зал")
        } else {
            println("Нельзя взять в читальный зал")
        }
    }

    override fun returnItem() {
        if (!available) {
            available = true
            println("Газета $name возвращена")
        } else {
            println("Эта газета уже доступна")
        }
    }
}