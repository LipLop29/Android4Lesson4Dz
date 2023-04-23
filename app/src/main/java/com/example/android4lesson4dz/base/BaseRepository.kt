package com.example.android4lesson4dz.base

import androidx.lifecycle.liveData
import com.example.android4lesson4dz.utils.Resource

abstract class BaseRepository {

    fun<T> doRequest(request : suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        }catch (exception : Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}