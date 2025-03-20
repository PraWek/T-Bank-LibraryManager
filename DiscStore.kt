package com.example.library

class DiscStore : Store {
    private var discIdCounter = 11 // Начнем нумерацию с 11

    override fun sell(): Disc {
        val newDisc = Disc(discIdCounter++, true, "Песни группы Кино", "CD")
        println("Продан диск: ${newDisc.name}")
        return newDisc
    }
}