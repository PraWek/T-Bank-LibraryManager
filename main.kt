import java.util.*

abstract class LibraryItem(
    val id: Int,
    var available: Boolean,
    val name: String
) {
    open fun getShortInfo(): String {
        return "$name доступна: ${if (available) "Да" else "Нет"}"
    }

    abstract fun getDetailedInfo(): String
}

class Book(
    id: Int,
    available: Boolean,
    name: String,
    val pageCount: Int,
    val author: String
) : LibraryItem(id, available, name) {
    override fun getDetailedInfo(): String {
        return "книга: $name ($pageCount стр.) автора: $author с id: $id доступна: ${if (available) "Да" else "Нет"}"
    }
}

class Newspaper(
    id: Int,
    available: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, available, name) {
    override fun getDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $name с id: $id доступен: ${if (available) "Да" else "Нет"}"
    }
}

class Disc(
    id: Int,
    available: Boolean,
    name: String,
    val type: String
) : LibraryItem(id, available, name) {
    override fun getDetailedInfo(): String {
        return "$type $name доступен: ${if (available) "Да" else "Нет"}"
    }
}

class LibraryManager {
    private val items = mutableListOf<LibraryItem>()
    private val takenItems = mutableListOf<LibraryItem>()

    init {
        items.add(Book(1, true, "Мы", 224, "Евгений Замятин"))
        items.add(Book(2, true, "1984", 320, "Джордж Оруэлл"))
        items.add(Book(3, false, "451 градус по Фаренгейту", 224, "Рэй Брэдбери"))
        items.add(Book(4, true, "О дивный новый мир", 351, "Олдос Хаксли"))
        items.add(Newspaper(5, false, "Правда", 1912))
        items.add(Newspaper(6, true, "Известия", 2023))
        items.add(Newspaper(7, true, "Коммерсантъ", 2024))
        items.add(Disc(8, true, "Автостопом по галактике", "DVD"))
        items.add(Disc(9, true, "Американский психопат", "DVD"))
        items.add(Disc(10, false, "Лучшие песни MACAN", "CD"))
    }

    fun showItems(type: String) {
        val filteredItems = when (type) {
            "книги" -> items.filterIsInstance<Book>()
            "газеты" -> items.filterIsInstance<Newspaper>()
            "диски" -> items.filterIsInstance<Disc>()
            else -> items
        }
        filteredItems.forEachIndexed { index, item ->
            println("${index + 1}. ${item.getShortInfo()}")
        }
    }

    fun selectItem(index: Int, type: String): LibraryItem? {
        val filteredItems = when (type) {
            "книги" -> items.filterIsInstance<Book>()
            "газеты" -> items.filterIsInstance<Newspaper>()
            "диски" -> items.filterIsInstance<Disc>()
            else -> items
        }
        return filteredItems.getOrNull(index - 1)
    }

    fun takeHome(item: LibraryItem) {
        if (item.available && (item is Book || item is Disc)) {
            item.available = false
            takenItems.add(item)
            println("${item::class.simpleName} ${item.id} взяли домой")
        } else {
            println("Нельзя взять домой")
        }
    }

    fun readInLibrary(item: LibraryItem) {
        if (item.available && (item is Book || item is Newspaper)) {
            item.available = false
            takenItems.add(item)
            println("${item::class.simpleName} ${item.id} взяли в читальный зал")
        } else {
            println("Нельзя читать (смотреть) в зале")
        }
    }

    fun returnItem(item: LibraryItem) {
        if (!item.available && item in takenItems) {
            item.available = true
            takenItems.remove(item)
            println("${item::class.simpleName} ${item.id} возвращён")
        } else if (item.available) {
            println("Этот объект уже доступен")
        } else {
            println("Вы не брали этот объект")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val manager = LibraryManager()

    while (true) {
        println("Выберите тип объекта:")
        println("1. Показать книги")
        println("2. Показать газеты")
        println("3. Показать диски")
        println("4. Выйти")
        when (scanner.nextInt()) {
            1 -> manageItems("книги", manager, scanner)
            2 -> manageItems("газеты", manager, scanner)
            3 -> manageItems("диски", manager, scanner)
            4 -> return
            else -> println("Некорректный выбор")
        }
    }
}

fun manageItems(type: String, manager: LibraryManager, scanner: Scanner) {
    manager.showItems(type)
    println("Выберите объект или введите 42 для возврата:")
    val choice = scanner.nextInt()
    if (choice == 42) return
    val item = manager.selectItem(choice, type)
    if (item != null) {
        while (true) {
            println("1. Взять домой")
            println("2. Читать в читальном зале")
            println("3. Показать подробную информацию")
            println("4. Вернуть")
            println("5. Назад")
            when (scanner.nextInt()) {
                1 -> manager.takeHome(item)
                2 -> manager.readInLibrary(item)
                3 -> println(item.getDetailedInfo())
                4 -> manager.returnItem(item)
                5 -> return
                else -> println("Некорректный выбор")
            }
        }
    } else {
        println("Некорректный выбор")
    }
}
