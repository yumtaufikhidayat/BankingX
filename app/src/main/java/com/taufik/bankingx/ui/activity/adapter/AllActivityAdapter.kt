package com.taufik.bankingx.ui.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taufik.bankingx.databinding.ItemAllActivityBinding
import com.taufik.bankingx.model.activity.AllActivity

class AllActivityAdapter : ListAdapter<AllActivity, AllActivityAdapter.ViewHolder>(ALL_ACTIVITY_DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllActivityAdapter.ViewHolder {
        return ViewHolder(
            ItemAllActivityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemAllActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AllActivity) {
            val mContext = itemView.context
            binding.apply {
                imgProfile.setImageDrawable(ContextCompat.getDrawable(mContext, data.profileImage))
                tvProfileName.text = data.profileName
                tvActivityStatus.text = data.activityStatus
                tvActivityBalance.text = data.activityBalance
                tvTimestampActivity.text = data.activityTimestamp
            }
        }
    }

    companion object {
        val ALL_ACTIVITY_DIFF_CALLBACK = object : DiffUtil.ItemCallback<AllActivity>() {
            override fun areItemsTheSame(oldItem: AllActivity, newItem: AllActivity): Boolean {
                return oldItem.activityId == newItem.activityId
            }

            override fun areContentsTheSame(oldItem: AllActivity, newItem: AllActivity): Boolean {
                return oldItem == newItem
            }
        }
    }
}