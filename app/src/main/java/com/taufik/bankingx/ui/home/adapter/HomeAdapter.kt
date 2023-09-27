package com.taufik.bankingx.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.bankingx.databinding.ItemHomeBinding
import com.taufik.bankingx.model.home.Home

class HomeAdapter(private val onClick: (Int) -> Int) : ListAdapter<Home, HomeAdapter.ViewHolder>(HOME_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Home) {
            binding.apply {
                imgMenu.setImageDrawable(ContextCompat.getDrawable(itemView.context, data.resource))
                tvMenuName.text = data.name
                clHome.setOnClickListener {
                    onClick(data.id)
                }
            }
        }
    }

    companion object {
        private val HOME_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Home>() {
            override fun areItemsTheSame(oldItem: Home, newItem: Home): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Home, newItem: Home): Boolean {
                return oldItem == newItem
            }
        }
    }
}