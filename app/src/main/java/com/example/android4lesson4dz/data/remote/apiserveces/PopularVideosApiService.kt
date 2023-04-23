package com.example.android4lesson4dz.data.remote.apiserveces

import com.example.android4lesson4dz.models.VideosModel
import com.example.android4lesson4dz.models.YouTubeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularVideosApiService {

    @GET("videos")
    suspend fun fetchPopularVideos(
        @Query("part") part: String = "snippet,statistics",
        @Query("regionCode") regionCode: String = "ru",
        @Query("chart") chart: String = "mostPopular",
        @Query("pageToken") pageToken: String
    ): YouTubeResponse<VideosModel>
}