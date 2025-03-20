package com.example.library

import com.example.library.kotlin.Digitalizable

class DigitizationOffice {
    private var discIdCounter = 1 // Начнем нумерацию дисков с 1
    fun digitize(item: Digitalizable): Disc {
        val digitalInfo = item.getDigitalInfo()
        val newDisc = Disc(
            discIdCounter++,
            true,
            "CD с цифровой копией: ${item.name}",
            "CD"
        ) // Создаем CD диск
        println("Создан CD диск: ${newDisc.name} с информацией: $digitalInfo")
        return newDisc
    }
}