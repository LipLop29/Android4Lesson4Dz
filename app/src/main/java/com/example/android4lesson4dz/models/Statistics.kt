package com.example.android4lesson4dz.models

import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String? = null,
    @SerializedName("likeCount")
    val likeCount: String
)