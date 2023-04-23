package com.example.android4lesson4dz.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson4dz.R
import com.example.android4lesson4dz.base.BaseFragment
import com.example.android4lesson4dz.databinding.FragmentHomeBinding
import com.example.android4lesson4dz.ui.adapters.PopularVideosAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private var popularVideosAdapter = PopularVideosAdapter()


    override fun initialize() {
        binding.recyclerAnime.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = popularVideosAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupObserves()
        viewModel.fetchPopularVideos().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                popularVideosAdapter.submitData(it)
            }
        }
    }
}