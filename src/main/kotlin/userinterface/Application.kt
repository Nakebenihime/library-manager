package userinterface

import external.Export
import usecases.Management

fun main() {
    val management = Management(export = Export())

    while (true) {
        println("Welcome to your library: ")
        println("press '1' to add a book")
        println("press '2' to list all books")
        println("press '3' to delete a book with UUID")
        println("press '4' to count the books in the library")
        println("press '5' to export the library")
        when (readLine()!!) {
            "1" -> management.addBookToLibrary()
            "2" -> management.showLibrary()
            "3" -> management.removeBookFromLibrary()
            "4" -> management.countBooksFromLibrary()
            "5" -> management.export()
            else -> {
                println("None of the keys were pressed")
            }
        }
    }
}