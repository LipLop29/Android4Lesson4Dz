package com.example.android4lesson4dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson4dz.base.BaseDiffUtilItemCallback
import com.example.android4lesson4dz.models.VideosModel
import com.example.android4lesson4dz.databinding.ItemYouTubeBinding
import com.example.android4lesson4dz.extention.setImage

class PopularVideosAdapter :
    PagingDataAdapter<VideosModel, PopularVideosAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    inner class ViewHolder(private val binding: ItemYouTubeBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun onBind(item: VideosModel?) = with(binding){
            temVideoTitleTv.text = item?.snippet?.title
            itemVideoImg.setImage(item?.snippet!!.thumbnails.res.url)
            itemViews.text = item.statistics.viewCount
            itemReleased.text = item.snippet.publishedAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemYouTubeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}