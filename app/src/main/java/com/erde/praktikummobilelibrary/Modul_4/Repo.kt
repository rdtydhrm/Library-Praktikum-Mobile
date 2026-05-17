package com.erde.praktikummobilelibrary.Modul_4

import kotlinx.coroutines.delay
import kotlin.random.Random

class Repo {
    companion object {
        suspend fun getData(): Int {
            delay(2000) // simulasi network request
            return Random.nextInt(100, 1000)
        }
    }
}