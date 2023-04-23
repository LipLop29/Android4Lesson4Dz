package com.example.android4lesson4dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android4lesson4dz.data.repositories.pagingsources.VideosPopularPagingSources
import com.example.android4lesson4dz.base.BaseRepository
import com.example.android4lesson4dz.data.remote.apiserveces.PopularVideosApiService
import javax.inject.Inject

class PopularVideosRepository @Inject constructor(
    private val service: PopularVideosApiService
) : BaseRepository() {

    fun fetchPopularVideos() =
        Pager(
            PagingConfig(
                pageSize = 20,
                initialLoadSize = 10
            )
        ){
            VideosPopularPagingSources(service)
        }.liveData
}