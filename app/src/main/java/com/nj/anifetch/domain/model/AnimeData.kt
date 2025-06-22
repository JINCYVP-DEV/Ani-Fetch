package com.nj.anifetch.domain.model

import com.nj.anifetch.data.remote.dto.Genre
import com.nj.anifetch.data.remote.dto.Images
import com.nj.anifetch.data.remote.dto.Trailer

data class AnimeData(
    val title: String,
    val duration:String,
    val score:Double,
    val year:Int,
    val images: Images,
    val genres: List<Genre>,
    val episodes: Int,
    val trailer: Trailer,
    val rank: Int,
    val synopsis:String)