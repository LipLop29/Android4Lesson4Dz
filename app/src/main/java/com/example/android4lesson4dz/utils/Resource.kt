package com.example.android4lesson4dz.utils

sealed class Resource<out T>(
    val data: T? = null,
    val massage: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(massage: String, data: T? = null) : Resource<T>(data = data, massage = massage)
}