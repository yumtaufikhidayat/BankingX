package com.taufik.bankingx.ui.wallet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.bankingx.databinding.ItemWalletBinding
import com.taufik.bankingx.model.wallet.Wallet
class WalletAdapter: ListAdapter<Wallet, WalletAdapter.ViewHolder>(WALLET_DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWalletBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemWalletBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Wallet) {
            val mContext = itemView.context
            binding.apply {
                tvWalletName.text = data.walletName
                tvWalletBalance.text = data.walletBalance
                imgWalletLogo.setImageDrawable(ContextCompat.getDrawable(mContext, data.walletLogo))
                cardWallet.setBackgroundResource(data.walletColor)
            }
        }
    }

    companion object {
        val WALLET_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Wallet>() {
            override fun areItemsTheSame(oldItem: Wallet, newItem: Wallet): Boolean {
                return oldItem.walletId == newItem.walletId
            }

            override fun areContentsTheSame(oldItem: Wallet, newItem: Wallet): Boolean {
                return oldItem == newItem
            }
        }
    }
}