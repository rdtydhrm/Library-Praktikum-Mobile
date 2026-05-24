package com.erde.praktikummobilelibrary.Modul_9

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://dicxytmhijsbclknsldb.supabase.co/rest/v1/"
    private const val API_KEY = "sb_publishable_h8XfawhUd-d7ogyDerpadw_PuUbsRGy"

    private val retrofit: Retrofit by lazy {
        val sbHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(ApiKeyInterceptor(API_KEY))
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(sbHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val bookService: BookService by lazy {
        retrofit.create(BookService::class.java)
    }
}