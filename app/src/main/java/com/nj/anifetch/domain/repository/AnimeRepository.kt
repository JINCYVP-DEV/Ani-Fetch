package com.nj.anifetch.domain.repository

import com.nj.anifetch.data.remote.dto.Data

interface AnimeRepository {
    suspend fun getAnimeList():List<Data>
    suspend fun getAnimeById(animeId:String):Data
}