package com.example.testshoppingapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.testshoppingapp.R
import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.data.model.ShopItem
import com.example.testshoppingapp.databinding.FragmentProductDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.example.testshoppingapp.presentation.viewmodel.ProductDetailViewModel
import com.example.testshoppingapp.data.util.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    @Inject
    lateinit var viewModel : ProductDetailViewModel
    private lateinit var binding : FragmentProductDetailBinding
    private lateinit var shopItem: ShopItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shopItem = ProductDetailFragmentArgs.fromBundle(requireArguments()).shopItem
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductDetailBinding.bind(view)

        binding.productDetailAddToCart.setOnClickListener {
            val cartItem = CartItemToSave(
                shopItem.id,
                shopItem.image,
                Utils.formatPrice(shopItem.price.toString()),
                shopItem.title,
                shopItem.category,
                shopItem.price)
            viewModel.saveToCart(cartItem)
            Snackbar.make(binding.productDetailAddToCart,"Product added to Cart",Snackbar.LENGTH_SHORT).show()
        }

        binding.productDetailCart.setOnClickListener {
            findNavController().navigate(R.id.action_productDetailFragment_to_cartFragment)
        }

        binding.productDetailBack.setOnClickListener {
            findNavController().navigateUp()
        }

        setInformationInView()

    }

    private fun setInformationInView() {
        binding.productCategory.text = shopItem.category
        binding.productDetailPrice.text = "${shopItem.price}"
        binding.productDetailTitle.text = shopItem.title
        binding.productDetailDescription.text = shopItem.description
        Glide.with(binding.productDetailImage)
            .load(shopItem.image)
            .into(binding.productDetailImage)
    }

}