package com.erde.praktikummobilelibrary.Modul_8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.erde.praktikummobilelibrary.Modul_8.ui.theme.PraktikumMobileLibraryTheme

class MainActivity : ComponentActivity() {
    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookDatabase: BookDatabase
    private lateinit var repository: BookRepository
    private lateinit var factory: BookViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookDatabase = BookDatabase(this)
        repository = BookRepository(bookDatabase)
        factory = BookViewModelFactory(repository)
        bookViewModel = ViewModelProvider(this, factory)[BookViewModel::class.java]

        setContent {
            PraktikumMobileLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                        bookViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(text = "JUDUL " + book.title)
            Text(text = "ISBN " + book.isbn)
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, bookViewModel: BookViewModel) {
    val itemList by bookViewModel.getAllBook().collectAsStateWithLifecycle(initialValue = listOf())
    var _title by remember { mutableStateOf("") }
    var _isbn by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(all = 50.dp)) {
        TextField(
            value = _title,
            onValueChange = { _title = it },
            label = { Text("JUDUL") },
        )
        TextField(
            value = _isbn,
            onValueChange = { _isbn = it },
            label = { Text("ISBN") },
        )
        Button(onClick = {
            val book = Book(id = null, title = _title, isbn = _isbn)
            bookViewModel.insert(book)
        }) { Text(text = "SIMPAN") }
        LazyColumn() {
            items(itemList) { book -> BookCard(book) }
        }
    }
}


