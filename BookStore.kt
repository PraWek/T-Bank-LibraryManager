package com.example.library

class BookStore : Store {
    private var bookIdCounter = 11

    override fun sell(): Book {
        val newBook = Book(bookIdCounter++, true, "Преступление и наказание",
            672, "Федор Достоевский")
        println("Продана книга: ${newBook.name}")
        return newBook
    }
}