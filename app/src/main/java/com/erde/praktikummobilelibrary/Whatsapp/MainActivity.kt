package com.erde.praktikummobilelibrary.Whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.erde.praktikummobilelibrary.Whatsapp.ui.theme.PraktikumMobileLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumMobileLibraryTheme {
                ChatList()
            }
        }
    }
}
