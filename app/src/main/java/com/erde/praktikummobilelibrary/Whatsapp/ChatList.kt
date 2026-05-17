package com.erde.praktikummobilelibrary.Whatsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatList() {
    val selectedTab = 0 // Tetapkan di index 0 (CHATS) agar statis
    val tabs = listOf("CHATS", "STATUS", "CALLS")

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color(0xFF075E54))) {
                TopAppBar(
                    title = { Text("WhatsApp", fontWeight = FontWeight.Bold, color = Color.White) },
                    actions = {
                        IconButton(onClick = { /* Tidak ada aksi */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        }
                        IconButton(onClick = { /* Tidak ada aksi */ }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More Options",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF075E54)
                    )
                )
                
                // Tab Section (Statis)
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Color(0xFF075E54),
                    contentColor = Color.White,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                            color = Color.White
                        )
                    },
                    divider = {}
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { /* Tidak ada aksi */ },
                            text = {
                                Text(
                                    text = title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = if (selectedTab == index) Color.White else Color.White.copy(alpha = 0.7f)
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        // Langsung menampilkan Chat List (Statis)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(dummyChats) { chat ->
                ChatItem(chat)
                HorizontalDivider(
                    modifier = Modifier.padding(start = 82.dp),
                    thickness = 0.5.dp,
                    color = Color.LightGray
                )
            }
        }
    }
}
