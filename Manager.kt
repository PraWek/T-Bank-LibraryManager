import com.example.library.LibraryItem
import com.example.library.Store

class Manager {
    fun buy(store: Store): LibraryItem {
        val item = store.sell()
        println("Менеджер купил: ${item.getShortInfo()}")
        return item
    }
}