package com.example.library

class DiscStore : Store {
    private val availableDiscs = mutableListOf(
        Disc(11, true, "Песни группы Кино", "CD"),
        Disc(12, true, "Лучшие хиты 90-х", "CD"),
        Disc(13, true, "Властелин колец", "DVD")
    )

    override fun getAvailableItems(): List<LibraryItem> = availableDiscs.toList()

    override fun sell(item: LibraryItem): LibraryItem {
        val disc = availableDiscs.find { it.id == item.id }
            ?: throw IllegalArgumentException("Диск не найден")
        availableDiscs.remove(disc)
        return disc
    }
}