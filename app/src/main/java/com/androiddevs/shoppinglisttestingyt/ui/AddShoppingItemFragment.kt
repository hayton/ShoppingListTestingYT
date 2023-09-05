package com.androiddevs.shoppinglisttestingyt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.androiddevs.shoppinglisttestingyt.R
import com.androiddevs.shoppinglisttestingyt.databinding.FragmentAddShoppingItemBinding

class AddShoppingItemFragment: Fragment(R.layout.fragment_add_shopping_item) {

    private lateinit var binding: FragmentAddShoppingItemBinding

    val viewModel by activityViewModels<ShoppingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddShoppingItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //todo: add test case to test navigation
        binding.ivShoppingImage.setOnClickListener {
            findNavController().navigate(
                AddShoppingItemFragmentDirections.actionAddShoppingItemFragmentToImagePickFragment()
            )
        }

        val callback = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //todo: test case to test url is empty
                viewModel.setCurImageUrl("")
                findNavController().popBackStack()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
}