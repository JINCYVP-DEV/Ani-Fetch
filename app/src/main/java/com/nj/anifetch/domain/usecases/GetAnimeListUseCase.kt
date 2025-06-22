package com.nj.anifetch.domain.usecases

import com.nj.anifetch.common.Resource
import com.nj.anifetch.data.remote.dto.toAnimeData
import com.nj.anifetch.domain.model.AnimeData
import com.nj.anifetch.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeListUseCase @Inject constructor(private val repository:AnimeRepository) {
    operator fun invoke(): Flow<Resource<List<AnimeData>>> = flow{
        try {
            emit(Resource.Loading())
            val anime= repository.getAnimeList().map{it.toAnimeData()}
            emit(Resource.Success(anime))
        }
        catch (e:Exception)
        {
            emit(Resource.Error(e.message?:"Something went wrong!"))
        }
    }
}