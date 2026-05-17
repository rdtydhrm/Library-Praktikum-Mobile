package com.erde.praktikummobilelibrary.Modul_8

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val title: String,
    val isbn: String
)