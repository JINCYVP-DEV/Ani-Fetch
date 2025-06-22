package com.nj.anifetch.domain.usecases

import com.nj.anifetch.common.Resource
import com.nj.anifetch.data.remote.dto.toAnimeData
import com.nj.anifetch.domain.model.AnimeData
import com.nj.anifetch.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAnimeByIdUseCase @Inject constructor(private val repository: AnimeRepository) {
    operator fun invoke(id:String): Flow<Resource<AnimeData>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getAnimeById(id).toAnimeData()
            emit(Resource.Success(data))
        }
        catch (e:Exception)
        {
            emit(Resource.Error(e.message?:"Something went wrong"))
        }
    }
}