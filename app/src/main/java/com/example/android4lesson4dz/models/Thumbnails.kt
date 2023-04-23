package com.example.android4lesson4dz.models

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("maxres")
    val res: Res
)