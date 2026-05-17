package com.erde.praktikummobilelibrary.Modul_5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GadgetItem(gadget: Gadget) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = gadget.name, style =
                MaterialTheme.typography.headlineMedium)
            Text(text = gadget.description, style =
                MaterialTheme.typography.bodyMedium)
        }
    }
}