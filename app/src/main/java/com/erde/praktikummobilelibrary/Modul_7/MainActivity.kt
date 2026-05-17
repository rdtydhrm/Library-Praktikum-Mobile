package com.erde.praktikummobilelibrary.Modul_7

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
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
import com.erde.praktikummobilelibrary.Modul_7.ui.theme.PraktikumMobileLibraryTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumMobileLibraryTheme {
                val vm: CalculatorScreenViewModel = viewModel()
                val discount = vm.discount.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        CalculatorScreen(
                            modifier = Modifier.padding(innerPadding),
                            discount = discount.value,
                            onClick = { vm.compute(it) },
                            onReset = { vm.reset() }
                        )
                        UserPanel(user = vm.user.collectAsState().value)
                    }
                }
            }
        }
    }
}

@Composable
fun UserPanel(modifier: Modifier = Modifier, user: User) {
    Column(modifier = modifier.padding(32.dp)) {
        Spacer(Modifier.size(16.dp))
        HorizontalDivider()
        Spacer(Modifier.size(16.dp))
        Text("Membership", fontSize = 24.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.size(16.dp))
        Text("${user.name}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(
            "${if (user.memberStatus) "Premium Member" else "Non-Member"}",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier,
                     discount: Int = 0,
                     onClick: (Int) -> Unit,
                     onReset: () -> Unit) {
    var number by rememberSaveable { mutableStateOf(0) }
    Column(modifier = modifier
        .padding(32.dp)
        .fillMaxWidth()) {
        Text("Transaction Amount",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light)
        Spacer(Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = number.toString(),
            onValueChange = { number = it.toIntOrNull() ?: 0 },
            textStyle = LocalTextStyle.current.copy(fontSize = 28.sp)
        )
        Spacer(Modifier.size(16.dp))
        Row(Modifier.align(Alignment.End)) {
            Button(onClick = { onClick(number) }) {
                Text(text = "Calculate")
            }
            Spacer(Modifier.size(8.dp))
            Button(onClick = { number = 0
                onReset()}) {
                Text(text = "Reset")
            }
        }
        Spacer(Modifier.size(16.dp))
        HorizontalDivider()
        Spacer(Modifier.size(16.dp))
        Text("Discount: $discount", fontSize = 24.sp)
    }
}