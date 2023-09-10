package com.androiddevs.shoppinglisttestingyt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.androiddevs.shoppinglisttestingyt.R
import com.androiddevs.shoppinglisttestingyt.adapters.ImageAdapter
import com.androiddevs.shoppinglisttestingyt.databinding.FragmentImagePickBinding
import com.androiddevs.shoppinglisttestingyt.di.other.Constants.GRID_SPAN_COUNT
import javax.inject.Inject

class ImagePickFragment @Inject constructor(
    val imageAdapter: ImageAdapter
): Fragment(R.layout.fragment_image_pick) {

    val viewModel by activityViewModels<ShoppingViewModel>()
    private lateinit var binding: FragmentImagePickBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImagePickBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageAdapter.setOnItemClickListener {
            findNavController().popBackStack()
            viewModel.setCurImageUrl(it)
        }
        setUpRecyclerview()
    }

    private fun setUpRecyclerview() {
        binding.rvImages.apply {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(requireContext(), GRID_SPAN_COUNT)

        }
    }
}