package com.androiddevs.shoppinglisttestingyt.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.androiddevs.shoppinglisttestingyt.R

class AddShoppingItemFragment: Fragment(R.layout.fragment_add_shopping_item) {

    val viewModel by activityViewModels<ShoppingViewModel>()

}