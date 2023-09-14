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
import com.androiddevs.shoppinglisttestingyt.di.other.Status
import com.bumptech.glide.RequestManager
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class AddShoppingItemFragment @Inject constructor(
    val glide: RequestManager
): Fragment(R.layout.fragment_add_shopping_item) {

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
        subscribeToObservers()

        binding.btnAddShoppingItem.setOnClickListener {
            viewModel.insertShoppingItem(
                binding.etShoppingItemName.text.toString(),
                binding.etShoppingItemAmount.text.toString(),
                binding.etShoppingItemPrice.text.toString()
            )
        }

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

    private fun subscribeToObservers() {
        viewModel.curImageUrl.observe(viewLifecycleOwner) {
            glide.load(it).into(binding.ivShoppingImage)
        }

        viewModel.insertShoppingItemStatus.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        Snackbar.make(
                            requireView(),
                            "Added Shopping Item",
                            Snackbar.LENGTH_LONG

                        ).show()
                    }
                    Status.ERROR -> {
                        Snackbar.make(
                            requireView(),
                            result.message ?: "An unknown error occurred",
                            Snackbar.LENGTH_LONG

                        ).show()
                    }
                    Status.LOADING -> {
                        /*No - op*/
                    }
                }
            }
        }
    }
}