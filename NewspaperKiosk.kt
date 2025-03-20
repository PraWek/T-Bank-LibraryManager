package com.example.library

class NewspaperKiosk : Store {
    private var newspaperIdCounter = 11

    override fun sell(): Newspaper {
        val newNewspaper = Newspaper(newspaperIdCounter++, true, "Ведомости", 1711, 7)
        println("Продана газета: ${newNewspaper.name}")
        return newNewspaper
    }
}