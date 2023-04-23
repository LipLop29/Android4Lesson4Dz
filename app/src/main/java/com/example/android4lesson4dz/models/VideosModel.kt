package com.example.android4lesson4dz.models

import com.example.android4lesson4dz.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class VideosModel(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    override val id: String,
    @SerializedName("snippet")
    val snippet: Snippet,
    @SerializedName("statistics")
    val statistics : Statistics
) : IBaseDiffModel