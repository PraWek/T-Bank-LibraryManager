package com.example.library

class NewspaperKiosk : Store {
    private val availableNewspapers = mutableListOf(
        Newspaper(11, true, "Ведомости", 1711, 7),
        Newspaper(12, true, "Комсомольская правда", 1523, 7),
        Newspaper(13, true, "Аргументы и факты", 842, 7)
    )

    override fun getAvailableItems(): List<LibraryItem> = availableNewspapers.toList()

    override fun sell(item: LibraryItem): LibraryItem {
        val newspaper = availableNewspapers.find { it.id == item.id }
            ?: throw IllegalArgumentException("Газета не найдена")
        availableNewspapers.remove(newspaper)
        return newspaper
    }
}