package com.erde.praktikummobilelibrary.Whatsapp

data class Chat(
    val id: Int,
    val senderName: String,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int = 0
)

val dummyChats = listOf(
    Chat(1, "Dini", "Halo, Sayang❤️", "10:30", 2),
    Chat(2, "Siti", "Sudah kirim tugasnya?", "09:15"),
    Chat(3, "Farel", "Besok jadi kumpul?", "Kemarin"),
    Chat(4, "Grup Alumni Aselole", "John Cena: Hahaha bener banget!", "Kemarin", 15),
    Chat(5, "Rina", "Oke siap.", "Selasa"),
    Chat(6, "Joko", "P", "Senin"),
    Chat(7, "Santi", "Makasih ya!", "01/10/26"),
    Chat(8, "Dono", "Wwokwow", "30/09/25"),
    Chat(9, "Indra", "Test test", "29/09/25"),
    Chat(10, "Maya", "Halo?", "28/09/25"),
    Chat(11, "Eko", "Otw", "27/09/25"),
    Chat(12, "Lina", "Bagus lah", "26/09/25"),
)
