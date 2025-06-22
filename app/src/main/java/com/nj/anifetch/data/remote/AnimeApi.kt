package com.nj.anifetch.data.remote

import com.nj.anifetch.data.remote.dto.Data
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {

    @GET("https://api.jikan.moe/v4/anime")
    suspend fun getAnimeList():List<Data>


    @GET("https://api.jikan.moe/v4/anime/{anime_id}")
    suspend fun getAnimeById(@Path("anime_id")anime_id:String):Data
}