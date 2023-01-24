package com.example.testshoppingapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testshoppingapp.R
import com.example.testshoppingapp.databinding.FragmentCartBinding
import com.example.testshoppingapp.presentation.adapter.CartAdapter
import com.example.testshoppingapp.presentation.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment : Fragment(){

    @Inject
    lateinit var cartViewModel: CartViewModel
    @Inject
    lateinit var cartAdapter: CartAdapter

    private lateinit var binding : FragmentCartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCartBinding.bind(view)

        cartViewModel.getCartItems().observe(viewLifecycleOwner){
            cartAdapter.differenceItems.submitList(it)
        }

        cartAdapter.setOnRemoveClickListener {
            cartViewModel.deleteCart(it)
        }

        binding.cartClear.setOnClickListener {
            cartViewModel.clearCart()
        }

        binding.cartBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.cartRecyclerView.adapter = cartAdapter

    }

}