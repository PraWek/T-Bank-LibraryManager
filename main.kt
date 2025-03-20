import com.example.library.LibraryManager
import java.util.Scanner

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