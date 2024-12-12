package com.example.kotlin_classes.abschluss_abgabe




class Library() {
    private val bookCollection = mutableListOf<Book>()

    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun getAddressInfo() = "Address: $street, $city, $zipCode"
        fun printAddressInfo() {
            println(getAddressInfo())
        }
    }
    inner class LibraryMember(val name: String, val memberId: Int) {
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("${book.title} checked out successfully by $name. Due date: $dueDate")
            } else {
                println("${book.title} is not available for checkout.")
            }
        }
        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("${book.title} reserved successfully by $name.")
            } else {
                println("${book.title} is not available for reservation.")
            }
        }
    }
    fun addBook(book: Book){
        bookCollection.add(book)
        println("Buch hinzugefügt: ${book.title}")
    }
    fun searchBook(title: String) {
        val foundBooks = bookCollection.filter { it.title.contains(title, ignoreCase = true) }
        if (foundBooks.isNotEmpty()) {
            println("Found books:")
            foundBooks.forEach { println("- ${it.title} by ${it.author}") }
        } else {
            println("No books found with title containing '$title'")
        }
    }
    fun searchBookByAuthor(author: String) {
        val foundBooks = bookCollection.filter { it.author.contains(author, ignoreCase = true) }
        if (foundBooks.isNotEmpty()) {
            println("Books by $author:")
            foundBooks.forEach { println("- ${it.title}") }
        } else {
            println("No books found by author '$author'")
        }
    }
    fun statusAllBooks(){
        println("Bücher in der Bibliothek:")
        bookCollection.forEach { book ->
        println("Buch: ${book.title}, Author: ${book.author}, Status: ${book.status}")


        }
    }
}
fun main() {
    val library = Library()

    // Adding address
    val address = Library.LibraryAddress("123 Library St", "Booktown", "12345")
    address.printAddressInfo()

    // Adding books
    val book1 = Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION, BookStatus.Available)
    val book2 = Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, BookStatus.Available)
    val book3 = Book("The Little Prince", "Antoine de Saint-Exupéry", Genre.CHILDREN, BookStatus.Available)
    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)

    // Searching books
    library.searchBook("Gatsby")
    library.searchBookByAuthor("Stephen Hawking")

    // Creating a library member
    val member = library.LibraryMember("Alice", 101)
    member.checkoutBook(book1, "2024-12-31")
    member.reserveBook(book2)

    // Displaying all book statuses
    library.statusAllBooks()
}
