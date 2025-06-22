package com.nj.anifetch.data.repository

import com.nj.anifetch.data.remote.AnimeApi
import com.nj.anifetch.data.remote.dto.Data
import com.nj.anifetch.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val api:AnimeApi) : AnimeRepository {
    override suspend fun getAnimeList(): List<Data> {
        return api.getAnimeList()
    }

    override suspend fun getAnimeById(animeId: String): Data {
    return api.getAnimeById(animeId)
    }
}