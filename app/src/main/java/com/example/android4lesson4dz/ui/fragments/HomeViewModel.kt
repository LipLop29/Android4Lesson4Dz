package com.example.android4lesson4dz.ui.fragments

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android4lesson4dz.base.BaseViewModel
import com.example.android4lesson4dz.data.repositories.PopularVideosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PopularVideosRepository
) : BaseViewModel() {

    fun fetchPopularVideos() = repository.fetchPopularVideos().cachedIn(viewModelScope)
}