package com.taufik.bankingx.ui.wallet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.bankingx.databinding.ItemSkinBinding
import com.taufik.bankingx.model.wallet.AddWallet

class AddWalletAdapter(
    private val onCLickListener: (Int) -> Unit
): ListAdapter<AddWallet, AddWalletAdapter.ViewHolder>(ADD_WALLET_DIFF_CALLBACK) {

    private var singleItemSelectionPosition = -1
    private var lastSelectedItemPosition = -1
    private var lastSelectedItemState = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSkinBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSkinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AddWallet) {
            binding.apply {
                imgSkinBackground.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        data.backgroundResource
                    )
                )
                imgSkinBackground.setOnClickListener {
                    onCLickListener(adapterPosition)
                    setSingleSelection(adapterPosition)
                }

                if (singleItemSelectionPosition == adapterPosition) {
                    if (lastSelectedItemPosition == singleItemSelectionPosition && lastSelectedItemState) {
                        lastSelectedItemState = false
                        imgSelectedSkin.isVisible = false
                    } else {
                        imgSelectedSkin.isVisible = true
                        lastSelectedItemPosition = adapterPosition
                        lastSelectedItemState = true
                    }
                } else {
                    imgSelectedSkin.isVisible = false
                }
            }
        }
    }

    private fun setSingleSelection(adapterPosition: Int) {
        if (adapterPosition == RecyclerView.NO_POSITION) return
        notifyItemChanged(singleItemSelectionPosition)
        singleItemSelectionPosition = adapterPosition
        notifyItemChanged(singleItemSelectionPosition)
    }

    companion object {
        private val ADD_WALLET_DIFF_CALLBACK = object : DiffUtil.ItemCallback<AddWallet>() {
            override fun areItemsTheSame(oldItem: AddWallet, newItem: AddWallet): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: AddWallet, newItem: AddWallet): Boolean {
                return oldItem == newItem
            }
        }
    }
}