package com.example.testshoppingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testshoppingapp.data.model.ShopItem
import com.example.testshoppingapp.databinding.SingleItemBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var onItemClickListener : ((ShopItem)-> Unit) = {}
    fun setOnItemClickListener(listener : (ShopItem)-> Unit){
        onItemClickListener = listener
    }

    private val callback = object : DiffUtil.ItemCallback<ShopItem>() {
        override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem == newItem
        }

    }

    val differenceItem = AsyncListDiffer(this,callback)

    inner class HomeViewHolder(private val binding : SingleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(shopItem: ShopItem){
            Glide.with(binding.itemImage)
                .load(shopItem.image)
                .into(binding.itemImage)
            binding.itemTitle.text = shopItem.title
            binding.itemDescription.text = shopItem.description
            binding.itemView.setOnClickListener {
                onItemClickListener(shopItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val shopItem = differenceItem.currentList[position]
        holder.bindData(shopItem)
    }

    override fun getItemCount() =  differenceItem.currentList.size

}