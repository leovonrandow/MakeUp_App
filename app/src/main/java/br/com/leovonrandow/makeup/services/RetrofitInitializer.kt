package br.com.leovonrandow.makeup.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder().
    baseUrl("https://run.mocky.io/v3/").
    addConverterFactory(GsonConverterFactory.create()).
    build()

    fun serviceArtists(): ServiceMakeupArtists{
        return retrofit.create(ServiceMakeupArtists::class.java)
    }
}