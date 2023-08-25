package com.androiddevs.shoppinglisttestingyt.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.androiddevs.shoppinglisttestingyt.R

class ImagePickFragment: Fragment(R.layout.fragment_image_pick) {

    val viewModel by activityViewModels<ShoppingViewModel>()

}