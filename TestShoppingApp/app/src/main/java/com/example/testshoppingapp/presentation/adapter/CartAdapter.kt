package com.example.testshoppingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.databinding.CartItemBinding
import com.example.testshoppingapp.data.util.Utils

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var removeListener : ((CartItemToSave) -> Unit) = {}

    fun setOnRemoveClickListener(listener : (CartItemToSave) -> Unit){
        removeListener = listener
    }

    private val callback = object : DiffUtil.ItemCallback<CartItemToSave>() {
        override fun areItemsTheSame(oldItem: CartItemToSave, newItem: CartItemToSave): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CartItemToSave, newItem: CartItemToSave): Boolean {
            return oldItem == newItem
        }

    }

    val differenceItems = AsyncListDiffer(this, callback)

    inner class CartViewHolder(private val binding : CartItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(cartItem: CartItemToSave){
            binding.cartItemName.text = cartItem.title
            binding.cartItemPrice.text = "${Utils.formatPrice(cartItem.price)}"
            Glide.with(binding.cartItemImage)
                .load(cartItem.image)
                .into(binding.cartItemImage)
            binding.cartItemDelete.setOnClickListener {
                removeListener(cartItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = differenceItems.currentList[position]
        holder.bindData(cartItem)
    }

    override fun getItemCount(): Int {
        return differenceItems.currentList.size
    }

}