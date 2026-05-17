//package com.erde.praktikummobilelibrary.PasteBinCoba
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.erde.praktikummobilelibrary.PasteBinCoba.ui.theme.PraktikumMobileLibraryTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            PraktikumMobileLibraryTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun TaskScreen() {
//    var taskText by remember { mutableStateOf("") }
//    var tasks by remember { mutableStateOf(listOf<String>()) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Demo State Hoisting",
////            style = typography.headlineSmall
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        TaskInputSection(
//            value = taskText,
//            onValueChange = { taskText = it },
//            onAddClick = {
//                if (taskText.isNotBlank()) {
//                    tasks = tasks + taskText
//                    taskText = ""
//                }
//            }
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Daftar Tugas",
//            style = typography.titleMedium
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        TaskList(tasks = tasks)
//    }
//}
//
//@Composable
//fun TaskInputSection(
//    value: String,
//    onValueChange: (String) -> Unit,
//    onAddClick: () -> Unit
//) {
//    Row(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        OutlinedTextField(
//            value = value,
//            onValueChange = onValueChange,
//            label = { Text("Masukkan tugas") },
//            modifier = Modifier.weight(1f)
//        )
//
//        Spacer(modifier = Modifier.width(8.dp))
//
//        Button(
//            onClick = onAddClick,
//            modifier = Modifier.height(56.dp)
//        ) {
//            Text("Tambah")
//        }
//    }
//}
//
//@Composable
//fun TaskList(tasks: List<String>) {
//    if (tasks.isEmpty()) {
//        Text("Belum ada tugas")
//    } else {
//        LazyColumn(
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            itemsIndexed(tasks) { index, task ->
//                Card(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(
//                        text = "${index + 1}. $task",
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//            }
//        }
//    }
//}