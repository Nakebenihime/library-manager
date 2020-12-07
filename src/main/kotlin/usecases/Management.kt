package usecases

import entities.Book
import entities.Library
import java.util.*

interface ExportLibrary {
    fun exportLibrary(library: Library)
}

class Management(private val export: ExportLibrary) {
    private val library = Library()

    /**
     * displays the available books in the library
     */
    fun showLibrary() {
        println("-- The library has the following books at its disposal:")
        library.books.forEach { book -> println("Book ID: " + book.id + " Book Author: " + book.author + " Book Title: " + book.title + " Book Gender: " + book.gender) }
    }

    /**
     * adds a book to the library
     */
    fun addBookToLibrary() {
        println("-- Author: ")
        val author = readLine()!!
        println("-- Title: ")
        val title = readLine()!!
        println("-- Gender: ")
        val genre = readLine()!!
        val book = Book(UUID.randomUUID(), author, title, genre)
        library.books.add(book)
    }

    /**
     * counts the number of books in the library
     */
    fun countBooksFromLibrary() {
        println("-- The library contains " + library.books.size + " books")
    }

    /**
     * removes the book from the library using its ID
     */
    fun removeBookFromLibrary() {
        println("-- Type the id of the book you want to remove:")
        val uuid = readLine()!!
        library.books.removeAll { it.id == UUID.fromString(uuid) }
    }

    /**
     * exports the library
     */
    fun export() {
        export.exportLibrary(library)
    }
}