package com.example.android4lesson4dz.data.repositories.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4lesson4dz.models.VideosModel
import com.example.android4lesson4dz.data.remote.apiserveces.PopularVideosApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val ANIME_PAGING_STARTING_PAGE_INDEX = ""

class VideosPopularPagingSources(private val popularVideosApiService: PopularVideosApiService) :
    PagingSource<String,VideosModel>() {

    override fun getRefreshKey(state: PagingState<String, VideosModel>): String? {
        var current: String? = ""

        val anchorPosition = state.anchorPosition

        CoroutineScope(Dispatchers.IO).launch {
            if (anchorPosition != null) {
                current = state.closestPageToPosition(anchorPosition)?.prevKey?.let {
                    popularVideosApiService.fetchPopularVideos(
                        pageToken = it
                    ).nextPageToken
                }
            }
        }
        return current
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, VideosModel> {
        return try {
            val startPage = params.key ?: ANIME_PAGING_STARTING_PAGE_INDEX
            val response = popularVideosApiService.fetchPopularVideos(
                pageToken = startPage
            )
            val nextPage = if (response.items.isEmpty()) null else response.nextPageToken
            val prevPage = if (startPage == ANIME_PAGING_STARTING_PAGE_INDEX) null else response.prevPageToken

            LoadResult.Page(
                data = response.items,
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}