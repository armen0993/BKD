package com.android.bkd.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.search.model.FilterModel
import com.android.bkd.ui.search.view_holder.FilterViewHolder

class FilterAdapter : RecyclerView.Adapter<FilterViewHolder>() {

    private val mItems = mutableListOf<FilterModel>()

    fun updateData(data: List<FilterModel>) {
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder =
        FilterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter, parent, false)
        )

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(mItems[position])
        holder.itemView.setOnClickListener {
            holder.mBinding.containerMain.setBackgroundResource(R.drawable.bg_rounded_yellow)
        }
    }

    override fun getItemCount(): Int = mItems.size
}