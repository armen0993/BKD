package com.android.bkd.ui.search.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemFilterBinding
import com.android.bkd.models.FilterModel


class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemFilterBinding.bind(itemView.rootView)

    fun bind(data : FilterModel){
        mBinding.data = data
    }
}