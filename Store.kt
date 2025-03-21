
package com.example.library

interface Store {
    fun getAvailableItems(): List<LibraryItem>
    fun sell(item: LibraryItem): LibraryItem
}
