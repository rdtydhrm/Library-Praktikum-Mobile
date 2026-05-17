package com.erde.praktikummobilelibrary.Modul_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erde.praktikummobilelibrary.Modul_5.ui.theme.PraktikumMobileLibraryTheme

class MainActivity : ComponentActivity() {
    val gadgets = listOf(
        Gadget(1, "Smartphone", "Perangkat komunikasi genggam"),
        Gadget(2, "Laptop", "Komputer portabel untuk bekerja"),
        Gadget(3, "Tablet", "Perangkat layar sentuh antara hp dan laptop"),
        Gadget(4, "Smartwatch", "Jam tangan pintar pelacak kesehatan"),
        Gadget(5, "Earbuds", "Perangkat audio nirkabel"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumMobileLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GadgetList(gadgets)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PraktikumMobileLibraryTheme {
        Greeting("Android")
    }
}