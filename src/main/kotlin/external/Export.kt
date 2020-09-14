package external

import com.google.gson.Gson
import entities.Library
import usecases.ExportLibrary
import java.io.File

class Export : ExportLibrary {

    private val document = "library.json"

    /**
     * library export in JSON format - first way of persisting data
     */
    override fun exportLibrary(library: Library) {
        val gson = Gson()
        File(document).writeText(gson.toJson(library.books))
    }

/*
    /**
     * library export in TXT format - second way of persisting data
     */
    override fun exportLibrary(library: Library) {
        File(document).printWriter().use { out ->
            library.books.forEach {
                out.println("${it.id},${it.author},${it.title},${it.gender}")
            }
        }

*/
}