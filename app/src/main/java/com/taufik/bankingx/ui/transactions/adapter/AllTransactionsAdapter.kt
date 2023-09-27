package com.taufik.bankingx.ui.transactions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.ItemAllTransactionsBinding
import com.taufik.bankingx.model.transactions.AllTransactions

class AllTransactionsAdapter : ListAdapter<AllTransactions, AllTransactionsAdapter.ViewHolder>(ALL_TRANSACTIONS_DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllTransactionsAdapter.ViewHolder {
        return ViewHolder(
            ItemAllTransactionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemAllTransactionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AllTransactions) {
            val mContext = itemView.context
            binding.apply {
                cardBgMenu.setCardBackgroundColor(ContextCompat.getColor(mContext, data.backgroundColor))
                imgMenu.setImageDrawable(ContextCompat.getDrawable(mContext, data.profileImage))
                tvProfileName.text = data.profileName
                tvActivityStatus.text = data.transactionsStatus
                tvActivityBalance.text = data.transactionsBalance
                tvActivityBalance.setTextColor(
                    when (adapterPosition) {
                        3, 4 -> ContextCompat.getColor(
                            itemView.context,
                            R.color.green_200
                        )

                        else -> ContextCompat.getColor(
                            itemView.context,
                            R.color.black
                        )
                    }
                )
                tvTimestampActivity.text = data.transactionsTimestamp
            }
        }
    }

    companion object {
        val ALL_TRANSACTIONS_DIFF_CALLBACK = object : DiffUtil.ItemCallback<AllTransactions>() {
            override fun areItemsTheSame(oldItem: AllTransactions, newItem: AllTransactions): Boolean {
                return oldItem.transactionsId == newItem.transactionsId
            }

            override fun areContentsTheSame(oldItem: AllTransactions, newItem: AllTransactions): Boolean {
                return oldItem == newItem
            }
        }
    }
}