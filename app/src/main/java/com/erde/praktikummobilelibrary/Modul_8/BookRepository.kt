package com.erde.praktikummobilelibrary.Modul_8

import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookStoreDatabase: BookDatabase) {
    fun getAllBook(): Flow<List<Book>> = bookStoreDatabase.getBookDao().getAllBooks()

    suspend fun insertBook(book: Book) =
        bookStoreDatabase.getBookDao().insertBook(book)
}