import com.example.library.LibraryManager
import com.example.library.BookStore
import com.example.library.DiscStore
import com.example.library.NewspaperKiosk
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val manager = LibraryManager()
    val storeManager = Manager() // Создаем экземпляр менеджера

    while (true) {
        println("Выберите действие:")
        println("1. Показать книги")
        println("2. Показать газеты")
        println("3. Показать диски")
        println("4. Менеджер") // Новый пункт меню для менеджера
        println("5. Выйти")
        when (scanner.nextInt()) {
            1 -> manageItems("книги", manager, scanner)
            2 -> manageItems("газеты", manager, scanner)
            3 -> manageItems("диски", manager, scanner)
            4 -> manageManagerActions(storeManager, scanner) // Управление менеджером
            5 -> return
            else -> println("Неверный ввод")
        }
    }
}

// Функция управления менеджером (вложенное меню)
fun manageManagerActions(storeManager: Manager, scanner: Scanner) {
    while (true) {
        println("Менеджер:")
        println("1. Купить")
        println("2. Назад")
        when (scanner.nextInt()) {
            1 -> manageBuying(storeManager, scanner) // Выбор магазина
            2 -> return
            else -> println("Неверный ввод")
        }
    }
}

// Функция покупки
fun manageBuying(storeManager: Manager, scanner: Scanner) {
    while (true) {
        println("Выберите магазин:")
        println("1. Магазин книг")
        println("2. Магазин дисков")
        println("3. Газетный ларек")
        println("4. Назад")

        when (scanner.nextInt()) {
            1 -> {
                val bookStore = BookStore()
                val purchasedBook = storeManager.buy(bookStore)
                println("Купленная книга: ${purchasedBook.getDetailedInfo()}")
            }
            2 -> {
                val discStore = DiscStore()
                val purchasedDisc = storeManager.buy(discStore)
                println("Купленный диск: ${purchasedDisc.getDetailedInfo()}")
            }
            3 -> {
                val newspaperKiosk = NewspaperKiosk()
                val purchasedNewspaper = storeManager.buy(newspaperKiosk)
                println("Купленная газета: ${purchasedNewspaper.getDetailedInfo()}")
            }
            4 -> return
            else -> println("Неверный ввод")
        }
    }
}

fun manageItems(type: String, manager: LibraryManager, scanner: Scanner) {
    manager.showItems(type)
    while (true) {
        println("Выберите действие:")
        println("1. Взять домой")
        println("2. Читать (смотреть) в зале")
        println("3. Вернуть")
        println("4. Посмотреть информацию об объекте")
        println("5. Назад")

        when (scanner.nextInt()) {
            1 -> {
                println("Выберите номер объекта:")
                val index = scanner.nextInt()
                val item = manager.selectItem(index, type)
                if (item != null) {
                    manager.takeHome(item)
                } else {
                    println("Объект не найден")
                }
            }

            2 -> {
                println("Выберите номер объекта:")
                val index = scanner.nextInt()
                val item = manager.selectItem(index, type)
                if (item != null) {
                    manager.readInLibrary(item)
                } else {
                    println("Объект не найден")
                }
            }

            3 -> {
                println("Выберите номер объекта:")
                val index = scanner.nextInt()
                val item = manager.selectItem(index, type)
                if (item != null) {
                    manager.returnItem(item)
                } else {
                    println("Объект не найден")
                }
            }

            4 -> {
                println("Выберите номер объекта:")
                val index = scanner.nextInt()
                val item = manager.selectItem(index, type)
                if (item != null) {
                    println(item.getDetailedInfo())
                } else {
                    println("Объект не найден")
                }
            }

            5 -> return
            else -> println("Неверный ввод")
        }
    }
}